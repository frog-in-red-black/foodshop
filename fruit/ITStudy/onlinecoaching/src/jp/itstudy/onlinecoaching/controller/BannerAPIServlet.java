package jp.itstudy.onlinecoaching.controller;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itstudy.onlinecoaching.db.BannerDb;
import jp.itstudy.onlinecoaching.model.BannerModel;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class BannerAPIServlet
 */
@WebServlet("/BannerAPIServlet")
public class BannerAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannerAPIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 写json格式调用 model
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*0,3*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//响应的hashmap
		HashMap<String, Object> result = new HashMap<>();
		result.put("result", "error");
		result.put("message", "暂时没有广告哦");
		
		int page =  (request.getParameter("page") == null ?  1 : Integer.parseInt(request.getParameter("page")));
		int count = (request.getParameter("count") == null ?  3 : Integer.parseInt(request.getParameter("count")));
		int startIndex = (page - 1) * count;
		
		BannerModel bannerModel = new BannerModel();
		ArrayList<BannerDb> bannerList = bannerModel.getBanner(startIndex, count);
		if(bannerList.size() > 0) {
			result.put("result", "success");
			result.put("message", "获取广告成功");
			result.put("data",bannerList);
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
