package InfectStatisticWeb.servlet;

import java.io.IOException;
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
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    //必须设置，否则跳转页面中文乱码
        response.setCharacterEncoding("utf-8");
        ProvinceDAO provinceDAO = new ProvinceDAOImpl();        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");                      
        String flag = request.getParameter("flag");
        String province = request.getParameter("province");
        
        
        Date today = new Date();
        
        //获取今天该省份数据
        HashMap<String, List<Province>> todayData = provinceDAO.dealOneProvince(df.format(today), province);
        List<Province> todayOneList = todayData.get("1");
        List<Province> todayAllList = todayData.get("2");       
        todayOneList.addAll(todayAllList);     
        
            Gson json = new Gson();
            String result = json.toJson(todayOneList);
            //System.out.println(result);
            response.getWriter().write(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
