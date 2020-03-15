package InfectStatisticWeb.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import InfectStatisticWeb.dao.ProvinceDAO;
import InfectStatisticWeb.dao.ProvinceDAOImpl;
import InfectStatisticWeb.pojo.Province;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    //必须设置，否则跳转页面中文乱码	    
	    response.setCharacterEncoding("utf-8");
	    request.setCharacterEncoding("utf-8");
	    ProvinceDAO provinceDAO = new ProvinceDAOImpl();        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");                      
        String flag = request.getParameter("flag");
        String province = request.getParameter("province");
        String date = request.getParameter("year") + "-" + request.getParameter("month") + "-" + request.getParameter("day");
        System.out.println(date);
        System.out.println(province);
        Date today = new Date();
        
        if (flag != null && !date.equals(df.format(today)))
        {
            System.out.println("进入");
            try
            {
                Date d = df.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(d);
                calendar.add(calendar.DATE, -1);
                Date yesterday = calendar.getTime();
                
                String year = String.format("%tY", d);
                String month = String.format("%tm", d);
                String day = String.format("%td", d);
                
                //获取今天该省份数据
                HashMap<String, List<Province>> todayData = provinceDAO.dealOneProvince(df.format(d), province);
                List<Province> todayOneList = todayData.get("1");
                List<Province> todayAllList = todayData.get("2");
                Province todayData1 = todayAllList.get(todayAllList.size() - 1);
                Province yesterdayData1 = todayAllList.get(todayAllList.size() - 2);
                int[] todayArray = todayData1.getData();
                int[] yesterdayArray = yesterdayData1.getData();
                
                //存放今日与昨日的对比
                String[] compareData = new String[6];
                for (int i = 0; i < 6; i ++)
                {
                    if ((todayArray[i] - yesterdayArray[i]) >= 0)
                    {
                        compareData[i] = "+" + (todayArray[i] - yesterdayArray[i]);
                    }
                    else 
                    {
                        compareData[i] = "" + (todayArray[i] - yesterdayArray[i]);
                    }
                }
                //发送省份名称
                request.setAttribute("provinceName", todayData1.getName());
                
                //发送日期
                request.setAttribute("year", year);
                request.setAttribute("month", month);
                request.setAttribute("day", day);
                
                //发送今日省份数据
                request.setAttribute("todayData", todayData1);
                
                //发送昨日省份对比数据
                request.setAttribute("compare1", compareData);   
                
                Gson json = new Gson();
                String result = json.toJson(todayOneList);
                System.out.println(result);
            } 
            catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
                               
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        }       
        //默认页面
        else 
        {
            
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);
            Date yesterday = calendar.getTime();
            String year = String.format("%tY", today);
            String month = String.format("%tm", today);
            String day = String.format("%td", today);
            
            //获取今天该省份数据
            HashMap<String, List<Province>> todayData = provinceDAO.dealOneProvince(df.format(today), province);
            List<Province> todayOneList = todayData.get("1");
            List<Province> todayAllList = todayData.get("2");
            Province todayData1 = todayAllList.get(todayAllList.size() - 1);
            Province yesterdayData1 = todayAllList.get(todayAllList.size() - 2);
            int[] todayArray = todayData1.getData();
            int[] yesterdayArray = yesterdayData1.getData();
            
            //存放今日与昨日的对比
            String[] compareData = new String[6];
            for (int i = 0; i < 6; i ++)
            {
                if ((todayArray[i] - yesterdayArray[i]) >= 0)
                {
                    compareData[i] = "+" + (todayArray[i] - yesterdayArray[i]);
                }
                else 
                {
                    compareData[i] = "" + (todayArray[i] - yesterdayArray[i]);
                }
            }
            
            //发送省份名称
            request.setAttribute("provinceName", todayData1.getName());
            //发送日期
            request.setAttribute("year", year);
            request.setAttribute("month", month);
            request.setAttribute("day", day);
            
            //发送今日省份数据
            request.setAttribute("todayData", todayData1);
            
            //发送昨日省份对比数据
            request.setAttribute("compare1", compareData);            
            /*
            if(typeString.equals("1"))
            {
                Gson json = new Gson();
                String result = json.toJson(todayOneList);
                response.getWriter().write(result);
            }
            else 
            {
                Gson json = new Gson();
                String result = json.toJson(todayAllList);
                response.getWriter().write(result);
            }
            */
            //发送新增确诊趋势、累计确诊趋势、累计治愈/死亡趋势
            
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
