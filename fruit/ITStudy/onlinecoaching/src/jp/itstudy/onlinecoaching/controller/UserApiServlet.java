package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itstudy.onlinecoaching.db.UserListDb;
import jp.itstudy.onlinecoaching.model.UserModel;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserApiServlet
 */
@WebServlet("/UserApiServlet")
public class UserApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserApiServlet() {
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
		//响应的hashmap
		HashMap<String, Object> result = new HashMap<>();
		result.put("result", "error");
		result.put("message", "没有用户。");
		
		//分页 默认1
		int page =  (request.getParameter("page") == null ?  1 : Integer.parseInt(request.getParameter("page")));
		//一页显示多少条 默认10
		int count = (request.getParameter("count") == null ?  10 : Integer.parseInt(request.getParameter("count")));
		//数据的起始位置
		int startIndex = (page - 1) * count;
		//排序名称
		String order = (request.getParameter("order") == null ?  "id" : request.getParameter("order"));
		//倒叙desc asc正序 默认正序
		String sort = (request.getParameter("sort") == null ?  "asc" : request.getParameter("sort") );
		//课程名称 默认空
		String userName = (request.getParameter("userName") == null ?  "" : request.getParameter("userName"));
					
		
		UserModel userModel = new UserModel();
		ArrayList<UserListDb> userList = userModel.getUserList(startIndex, count, order, sort, userName);
		if(userList.size() > 0) {
			result.put("result", "success");
			result.put("message", "获取用户成功");
			result.put("data",userList);
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
