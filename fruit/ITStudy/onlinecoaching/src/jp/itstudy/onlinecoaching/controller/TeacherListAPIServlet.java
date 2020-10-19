package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itstudy.onlinecoaching.db.UserDb;
import jp.itstudy.onlinecoaching.model.UserModel;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class TeacherListAPIServlet
 */
@WebServlet("/TeacherListAPIServlet")
public class TeacherListAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherListAPIServlet() {
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
		response.setContentType("text/html; charset=UTF-8");
		
	
		HashMap<String, Object> result=new HashMap<>();
		result.put("result", "error");
		result.put("message", "暂时没有老师");
		int page =(request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page")));
		int count=(request.getParameter("count")==null?4:Integer.parseInt(request.getParameter("count")));
		int startIndex=(page-1)*count;
		UserModel userModel=new UserModel();
		ArrayList<UserDb> teacherList=userModel.getTeacherList(startIndex, count);
		
		if (teacherList.size()>0) {
			result.put("result", "success");
			result.put("message", "获取老师成功");
			result.put("data", teacherList);
		}
				
		
		JSONObject.fromObject(result).write(response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
