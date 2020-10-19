package jp.itstudy.onlinecoaching.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itstudy.onlinecoaching.model.OrderModel;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/CancelOrderServlet")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
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
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("result", "error");
		
		//判断是否管理员
		HttpSession session = request.getSession();
		if(session.getAttribute("uid") != null && Integer.parseInt(String.valueOf(session.getAttribute("uid"))) > 0
				&& Integer.parseInt(String.valueOf(session.getAttribute("role"))) == 3) {
			
			int orderId = 0;
			if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
				orderId =Integer.valueOf(request.getParameter("orderId"));
				OrderModel orderModel = new OrderModel();
				int  orderResult = orderModel.cancelOrder(orderId);
				if(orderResult >0) {
					result.put("result","success");
				}							
			}
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
