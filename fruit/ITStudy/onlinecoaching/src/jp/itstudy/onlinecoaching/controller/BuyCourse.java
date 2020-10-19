package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itstudy.onlinecoaching.db.OrderDb;
import jp.itstudy.onlinecoaching.model.OrderModel;

/**
 * Servlet implementation class BuyCourse
 */
@WebServlet("/BuyCourse")
public class BuyCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int courseId;
		OrderDb orderDb=new OrderDb();
		
		if(request.getParameter("courseId")!=null&&request.getParameter("courseId").isEmpty()) {
			courseId=Integer.valueOf(request.getParameter("courseId"));
			orderDb.setCourseId(courseId);
			
			OrderModel orderModel=new OrderModel();
			//orderModel.addOder(orderDb);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
