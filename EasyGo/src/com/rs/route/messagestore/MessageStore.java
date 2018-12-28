package com.rs.route.messagestore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rs.method.Methods;
import com.rs.util.bean.ReqAndRes;
import com.rs.util.bean.ReqBean;

/**消息抄送
 * 
 * @author wcs
 *
 */
public class MessageStore extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private Gson gson ;
	
	public MessageStore() {
		super();
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		gson  = new Gson();
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

	/**对消息抄送进行验证是否篡改
	 * 对网易云信平台进行响应 http状态码200为成功，414为失败。
	 * 对消息进行存储操作
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = RequestHelp.verify(request) ? 200 : 414;//验证数据是否被篡改
		
		response.setStatus(code);
		System.out.println("发送之后");
		if(code == 200) {
			ReqBean reqBean = ReqAndRes.toReqBean(request, gson);
			Methods.store(reqBean);
		}
		
	}

}
