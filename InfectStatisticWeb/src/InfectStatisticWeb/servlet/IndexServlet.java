package InfectStatisticWeb.servlet;

import java.util.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    /*
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setHeader("Content-Type","text/html;charset=UTF-8");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Date today = new Date();
        
        //String string = "2020-01-20";
        //Date d = df.parse(string); 
               
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        
        //获取今日全国数据
        ProvinceDAO provinceDAO = new ProvinceDAOImpl();
        //List<Province> todayProvince = provinceDAO.deal(df.format(today));
        List<Province> todayProvince = provinceDAO.dealOneDay("2020-02-02");
        Province todayCountry = provinceDAO.getCountry(); 
        int[] todayData = todayCountry.getData();
        
        //获取昨日全国数据
        //List<Province> yesterdayProvince = provinceDAO.deal(df.format(yesterday));
        List<Province> yesterdayProvince = provinceDAO.dealOneDay("2020-01-19");
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
                     
        //发送今日全国数据
        //发送昨日全国对比数据
        //发送各省现有、累计确诊        
        
        Gson json = new Gson();
        String result = json.toJson(todayProvince);
        System.out.println(result);
        response.getWriter().write(result);
        */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
