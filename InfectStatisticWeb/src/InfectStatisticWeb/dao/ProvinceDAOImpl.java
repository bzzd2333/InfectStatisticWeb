package InfectStatisticWeb.dao;

import java.io.*;
import java.util.HashMap;

import InfectStatisticWeb.pojo.Province;
import InfectStatisticWeb.util.FileUtil;

public class ProvinceDAOImpl implements ProvinceDAO
{

    public HashMap<String,Province> init()
    {
        HashMap<String,Province> map = new HashMap<String, Province>();
        for (int i = 0; i < FileUtil.provinceName.length; i ++ )
        {
            map.put(FileUtil.provinceName[i], new Province(FileUtil.provinceName[i]));
        }
        return map;
    }

    public HashMap<String,Province> deal(String date) throws IOException
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
                br = new BufferedReader(new InputStreamReader(new FileInputStream(tempList[i].toString()), "GBK"));  
                
                while ((line = br.readLine()) != null)
                {
                    String[] array = line.split(" ");
                    System.out.println(line);
                    dealOneLine(map, array);
                }          
                br.close();
            }                               
        }

        //allStatistic();
        
        return map;
    }
    

    public void dealOneLine(HashMap<String,Province> map, String[] array) 
    {

        if (array[0].equals("//") || array[0].equals(""))
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
            case "死亡":
                map.get(array[0]).dead(array[2]);
                break;
            case "治愈":
                map.get(array[0]).cure(array[2]);
                break;
            case "排除":
                map.get(array[0]).removeSp(array[3]);
                break;
            default:
                break;
        }   
    }
    
    public static void main(String args[])
    {
        ProvinceDAO testDao = new ProvinceDAOImpl();
        try
        {
            HashMap<String,Province> map = testDao.deal("2020-01-20");
            for (String key : map.keySet())
            {
                map.get(key).output();
            }
        } 
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
