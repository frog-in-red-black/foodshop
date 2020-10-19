package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itstudy.onlinecoaching.db.CourseDb;
import jp.itstudy.onlinecoaching.model.CourseModel;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class RecommandCourseApiServlet
 */
@WebServlet("/RecommandCourseApiServlet")
public class RecommandCourseApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommandCourseApiServlet() {
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
		result.put("message", "没有推荐课程。");
		//int[] CourseIdList= {1,2,3,4};
		//分页 默认1
		int page =  (request.getParameter("page") == null ?  1 : Integer.parseInt(request.getParameter("page")));
		//一页显示多少条 默认10
		int count = (request.getParameter("count") == null ?  4 : Integer.parseInt(request.getParameter("count")));
		//数据的起始位置
		int startIndex = (page - 1) * count;
		//选择不同的课程 默认1 ，1：推荐，2：热门 3：我的课程
		int action = (request.getParameter("action") == null ?  1 : Integer.parseInt(request.getParameter("action")));
		
				
		CourseModel courseModel = new CourseModel();
		ArrayList<CourseDb> resultList = new ArrayList<>();
		String message = "";
		if(action == 1) {
			resultList = courseModel.getRecommandCourseByCourseId(startIndex,count);
			message = "获取推荐课程成功";
		}else if(action == 2) {
			resultList = courseModel.getHostCourse(startIndex,count);
			message = "获取热门程成功";
		}else if(action == 3) {
			//修改修改地方
			//HttpSession session = request.getSession();
			 //if(session.getAttribute("uid") == null || Integer.parseInt(String.valueOf(session.getAttribute("uid"))) == 0){   
				 int uid = 1;//Integer.parseInt(String.valueOf(session.getAttribute("uid")));
				 resultList = courseModel.getCourseByUid(uid,startIndex,count);
				 message = "获取我课程成功";
			// }
		}
				
		if (resultList.size()>0) {
			result.put("result", "success");
			result.put("message",message );
			result.put("data", resultList);
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
