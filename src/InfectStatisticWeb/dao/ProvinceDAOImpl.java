package InfectStatisticWeb.dao;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gson.Gson;

import InfectStatisticWeb.pojo.Province;
import InfectStatisticWeb.util.FileUtil;

public class ProvinceDAOImpl implements ProvinceDAO
{
    //存放全国情况
    private Province country;
    
    //初始化
    public HashMap<String,Province> init()
    {
        country = new Province("全国");
        HashMap<String,Province> map = new LinkedHashMap<String, Province>();
        for (int i = 0; i < FileUtil.provinceName.length; i ++ )
        {
            map.put(FileUtil.provinceName[i], new Province(FileUtil.provinceName[i]));
        }
        return map;
    }
    
    //处理全国一天的情况
    public List<Province> dealOneDay(String date) throws IOException
    {      
        HashMap<String,Province> map = init();
        String logDate;     
        String[] sArray;
        File file = new File(FileUtil.logPath);
        File[] tempList = file.listFiles();
                      

        for (int i = 0; i < tempList.length; i ++ )                   
        {       
                      
            logDate = new String(tempList[i].getName());                      
            sArray = logDate.split("\\.");                    
            logDate = new String(sArray[0]);
                                                        
            if (logDate.compareTo(date) <= 0)                      
            {                 
                BufferedReader br = null;               
                String line = null;         
                br = new BufferedReader(new InputStreamReader(new FileInputStream(tempList[i].toString()), "UTF-8"));  
                
                while ((line = br.readLine()) != null)
                {
                    String[] array = line.split(" ");
                    //System.out.println(line);
                    dealOneLine(map, array);
                }          
                br.close();
            }                               
        }
        //统计全国情况
        allStatistic(map);
        
        return mapToList(map);
    }
        
    //处理指定省份从疫情开始以来每天的情况
    public HashMap<String, List<Province>> dealOneProvince(String date, String provinceName) throws IOException
    {        
        //存放该省份每天新增的趋势
        List<Province> provinceEverydayNew = new ArrayList<Province>();
        //存放该省份从疫情开始每天的趋势
        List<Province> provinceEverydayAll = new ArrayList<Province>();
        //存放List:provinceEverydayNew与provinceEverydayAll
        HashMap<String, List<Province>> allData = new HashMap<String, List<Province>>();
        HashMap<String,Province> map = new LinkedHashMap<String, Province>();       
        Province provinceAllDay = new Province(provinceName);  
        
        String logDate;     
        String[] sArray;
        File file = new File(FileUtil.logPath);
        File[] tempList = file.listFiles();
        
        map.put(provinceName, provinceAllDay);
        allData.put("1",provinceEverydayNew);
        allData.put("2",provinceEverydayAll);
                      

        for (int i = 0; i < tempList.length; i ++ )                   
        {       
                      
            logDate = new String(tempList[i].getName());                      
            sArray = logDate.split("\\.");                    
            logDate = new String(sArray[0]);
            //读取的日志符合要求                                            
            if (logDate.compareTo(date) <= 0)                      
            {      
                HashMap<String,Province> tempMap = new LinkedHashMap<String, Province>();        
                Province provinceOneday = new Province(provinceName);
                
                provinceOneday.setDate(logDate);
                provinceAllDay.setDate(logDate);
                tempMap.put(provinceName, provinceOneday);
                

                BufferedReader br = null;               
                String line = null;         
                br = new BufferedReader(new InputStreamReader(new FileInputStream(tempList[i].toString()), "UTF-8"));  
                
                while ((line = br.readLine()) != null)
                {
                    String[] array = line.split(" ");
                    //System.out.println(line);
                    dealOneLine(tempMap, array);
                    dealOneLine(map, array);
                }          
                br.close();
                Province temProvince = new Province(map.get(provinceName));
                //temProvince.output();
                //provinceOneday.output();
                provinceEverydayNew.add(provinceOneday);
                provinceEverydayAll.add(temProvince);
            }                               
        }
                
        return allData;
    }
    
    //处理日志中的一行
    public void dealOneLine(HashMap<String,Province> map, String[] array) 
    {

        if (array[0].equals("//") || array[0].equals(""))
        {
            return;
        }
        
        if(map.get(array[0]) == null)
        {
            return;
        }
        
        switch (array[1])
        {
            case "新增":
                if (array[2].equals("疑似患者"))
                {
                    map.get(array[0]).addSp(array[3]);
                }
                else if(array[2].equals("重症患者"))
                {
                    map.get(array[0]).addCr(array[3]);
                    map.get(array[0]).addIp(array[3]);
                    map.get(array[0]).addAllIp(array[3]);
                }
                else 
                {
                    map.get(array[0]).addIp(array[3]);
                    map.get(array[0]).addAllIp(array[3]);
                }
                break;                 
            case "疑似患者":
                map.get(array[0]).addIp(array[3]);
                map.get(array[0]).addAllIp(array[3]);
                map.get(array[0]).removeSp(array[3]);
                break;
            case "感染患者":
                map.get(array[0]).addCr(array[3]);
                break;
            case "死亡":
                if(array[2].equals("重症患者"))
                {
                    map.get(array[0]).dead(array[3]);
                    map.get(array[0]).removeCr(array[3]);
                }
                else 
                {
                    map.get(array[0]).dead(array[2]);
                }                
                break;
            case "治愈":
                if(array[2].equals("重症患者"))
                {
                    map.get(array[0]).removeCr(array[3]);
                    map.get(array[0]).cure(array[3]);
                }
                else 
                {
                    map.get(array[0]).cure(array[2]);
                }               
                break;
            case "排除":
                map.get(array[0]).removeSp(array[3]);
                break;
            default:
                break;
        }   
    }
    
    //统计全国数据
    public void allStatistic(HashMap<String,Province> map)
    {
        for (int i = 0; i < FileUtil.provinceName.length; i ++ )
        {            
            country.allAdd(map.get(FileUtil.provinceName[i]));        
        }        
    }
    
    //获取全国数据
    public Province getCountry()
    {
        return country;
    }
    
    //HashMap转换为List
    public List<Province> mapToList(HashMap<String,Province> map)
    {
        List<Province> provinces = new ArrayList<Province>();
        Iterator<java.util.Map.Entry<String,Province>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            java.util.Map.Entry<String, Province> next = iterator.next();
            provinces.add(next.getValue());
        }
        return provinces;
    }
    
    
    
        
    public static void main(String args[]) throws IOException, ParseException
    {
        
        ProvinceDAO provinceDAO = new ProvinceDAOImpl();  
        /*
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");        
        Date today = new Date();
        
        String string = "2020-01-20";
        Date d = df.parse(string); 
               
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        
        //获取今日全国数据        
        //List<Province> todayProvince = provinceDAO.deal(df.format(today));
        //List<Province> todayProvince = provinceDAO.dealOneDay("2020-02-02");
        Province todayCountry = provinceDAO.getCountry(); 
        int[] todayData = todayCountry.getData();
        
        //获取昨日全国数据
        //List<Province> yesterdayProvince = provinceDAO.deal(df.format(yesterday));
        //List<Province> yesterdayProvince = provinceDAO.dealOneDay("2020-01-19");
        Province yesterdayCountry = provinceDAO.getCountry();        
        int[] yesterdayData = yesterdayCountry.getData(); 
        
        String[] compareData = new String[5];
        for (int i = 0; i < 5; i ++)
        {
            if ((todayData[i] - yesterdayData[i]) >= 0)
            {
                compareData[i] = "+" + (todayData[i] - yesterdayData[i]);
            }
            else 
            {
                compareData[i] = "+" + (todayData[i] - yesterdayData[i]);
            }
            //System.out.println(compareData[i]);
        }
        */
        //发送今日全国数据
        
        //发送昨日全国对比数据
        //发送各省现有、累计确诊        
        
        List<Province> dataHashMap = provinceDAO.dealOneDay("2020-03-13");
        Province todayCountry = provinceDAO.getCountry(); 
        //List<Province> oneList = dataHashMap.get("1");
        //List<Province> allList = dataHashMap.get("2");
        
        
        
        
        Gson json = new Gson();
        String result = json.toJson(todayCountry);
        System.out.println(result);
        //result = json.toJson(allList.get(allList.size() - 2));
        //System.out.println(result);
        //result = json.toJson(todayProvince);
        //System.out.println(result);
        //response.getWriter().write(result);
    }

    
    
}
