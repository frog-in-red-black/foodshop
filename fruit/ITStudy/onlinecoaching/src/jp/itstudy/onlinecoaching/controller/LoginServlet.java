package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itstudy.onlinecoaching.db.UserDb;
import jp.itstudy.onlinecoaching.model.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//第一编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String url = "userLogin.jsp";
		StringBuffer sBuffer = new StringBuffer("用户账号或者密码错误请重新登录");
		String userName = "";
		String userPassword = "";
		
		//第二步接收，判断参数
		if(request.getParameter("userName") != null &&  !request.getParameter("userName").isEmpty()) {
			userName = request.getParameter("userName");
		}
		
		if(request.getParameter("userPassword") != null &&  !request.getParameter("userPassword").isEmpty()) {
			userPassword = request.getParameter("userPassword");
		}
		
		//第三步，验证用户名密码
		if(!userName.isEmpty() && !userPassword.isEmpty()) {
			UserModel userModel = new UserModel();
			UserDb userDb = userModel.getUser(userName, userPassword);
			if(userDb.getUserId() > 0) {
				url = (userDb.getUserRole() == 2) ? "" : "";
				sBuffer = new StringBuffer(userDb.getUserPhone()+"登录成功");
				
				HttpSession session = request.getSession();
				session.setAttribute("uid", userDb.getUserId());
				session.setAttribute("role", userDb.getUserRole());
				session.setAttribute("userName", userDb.getUserTruename());
			}
		}
		
		
		response.getWriter().append(sBuffer + ",<a href='"+ url +"'>点击跳转页面</a>");
	}

}
