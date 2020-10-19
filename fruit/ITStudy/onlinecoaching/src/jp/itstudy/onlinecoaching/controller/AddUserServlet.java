package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itstudy.onlinecoaching.db.UserDb;
import jp.itstudy.onlinecoaching.model.UserModel;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		UserDb userDb= new UserDb();
		//相应的hashmap
		HashMap<String, Object> result=new HashMap<>();
		result.put("result", "error");
		result.put("message", "添加用户失败");
		
		HttpSession session=request.getSession();
		if (session.getAttribute("uid") != null &&Integer.parseInt(String.valueOf(session.getAttribute("uid"))) >0
				&&Integer.parseInt(String.valueOf(session.getAttribute("role"))) ==2) {
				
			if(request.getParameter("userTrueName") != null &&  !request.getParameter("userTrueName").isEmpty()) {
				
				userDb.setUserTruename(request.getParameter("userTrueName"));
			}
			
			if(request.getParameter("userPassword") != null &&  !request.getParameter("userPassword").isEmpty()) {
					
			
				userDb.setUserPassword(request.getParameter("userPassword"));
		}
			if(request.getParameter("userRole") != null &&  !request.getParameter("userRole").isEmpty()) {
				
				
				userDb.setUserRole(Byte.parseByte(request.getParameter("userRole")));
			}
			if(request.getParameter("userStatus") != null &&  !request.getParameter("userStatus").isEmpty()) {
				
				
				userDb.setUserStatus(Byte.parseByte(request.getParameter("userStatus")));
			}
			if(userDb.getUserTruename()!=null
					&&userDb.getUserPassword()!=null
					&&userDb.getUserRole()!=0
					&&userDb.getUserStatus()!=0) {
				UserModel userModel=new UserModel();
				int userResult =userModel.addUser(userDb);
				if (userResult>0) {
					result.put("result", "success");
					result.put("message", "添加用户成功");
				}
				
			}
		
			
		}
		JSONObject.fromObject(result).write(response.getWriter());
	}

}
