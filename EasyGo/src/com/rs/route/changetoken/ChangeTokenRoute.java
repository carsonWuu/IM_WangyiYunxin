package com.rs.route.changetoken;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rs.properties.util.Basic;
import com.rs.properties.util.GetToken;
import com.rs.util.bean.ReqAndRes;
import com.rs.util.bean.ReqBean;
/**提供更新token值接口
 * 
 * @author wcs
 * @url /gettoken
 */
public class ChangeTokenRoute extends HttpServlet {
	private Gson gson ;
	/**
	 * Constructor of the object.
	 */
	public ChangeTokenRoute() {
		super();
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
		gson = new Gson();
	}
	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReqBean reqBean = ReqAndRes.toReqBean(request, gson);
		/*
		 * 根据userid进行token获取
		 */
		System.out.println(reqBean.getUserid());
		String token = GetToken.getToken(reqBean.getUserid(), Basic.refreshURL);
		Map map = new HashMap();
		map.put("userid", reqBean.getUserid());
		map.put("token", token);
		ReqAndRes.outPrint(response, map, gson);
	}

	

}
