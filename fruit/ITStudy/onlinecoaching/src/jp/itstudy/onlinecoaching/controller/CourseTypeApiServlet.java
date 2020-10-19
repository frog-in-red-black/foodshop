package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itstudy.onlinecoaching.db.CourseTypeDb;
import jp.itstudy.onlinecoaching.model.CourseTypeModel;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CourseTypeApiServlet
 */
@WebServlet("/CourseTypeApiServlet")
public class CourseTypeApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseTypeApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取分类
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 响应hashmap
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("result", "error");
		result.put("message", "没有课程类型");
		
		
		CourseTypeModel courseTypeModel = new CourseTypeModel();
		ArrayList<CourseTypeDb> courseType = courseTypeModel.getTypeAll();
				
		if (courseType.size()>0) {
			result.put("result", "success");
			result.put("message","获取课程分类成功" );
			result.put("data", courseType);
		}
		
		//通过hashMap转为josn格式数据
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
