package InfectStatisticWeb.servlet;

import java.util.*;
import java.io.IOException;
import java.text.ParseException;
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
public class IndexServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	           
	    //response.getWriter().append("Served at: ").append(request.getContextPath());	 
	    response.setCharacterEncoding("utf-8");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");                      
		String flag = request.getParameter("flag");		
		String date = request.getParameter("Date"); 
		System.out.println(date);
		
		//ѡ������ѡ��
		if (flag != null && flag.equals("date"))
		{		    
		    ProvinceDAO provinceDAO = new ProvinceDAOImpl(); 
		    System.out.println("����");                   
            //��ȡ����ȫ������        
            List<Province> todayProvince = provinceDAO.dealOneDay(date);
                                                       
            //���͸�ʡ���С��ۼ�ȷ������ 
            Gson json = new Gson();
            String result = json.toJson(todayProvince);
            System.out.print(result);
            response.getWriter().write(result);    
		}
		//��תҳ��ѡ��
		else if(flag != null && flag.equals("jump"))	 
		{
		    String province = request.getParameter("province");
		    System.out.print(province);
		    request.setAttribute("province", province);
		    request.getRequestDispatcher("DetailServlet").forward(request, response);
		}
		//Ĭ��ҳ��
		else 
		{
		    ProvinceDAO provinceDAO = new ProvinceDAOImpl(); 
		    Date today = new Date();
	     	        
	        //��ȡ����ȫ������        
	        List<Province> todayProvince = provinceDAO.dealOneDay(df.format(today));
	        	       	        	                   
	        //���͸�ʡ���С��ۼ�ȷ������ 
	        Gson json = new Gson();
	        String result = json.toJson(todayProvince);
	        //System.out.print(result);
	        response.getWriter().write(result);	            
            
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
