package test.sample;

import test.httputil.HttpUtil;
import test.tosend.Send;

public class Sample {
	private static final String URL = "http://192.168.1.101:8080/EasyGo/";
	
	public static void main(String[] args) throws Exception {
		
		String params=Send.tosend();
	
		System.out.println(params);
		String ret =null;
//存储验证码：{"phone_number":"180000000","code":"1234"}
		ret = test("messagestore",params);	
		System.out.println(ret);

	}
	
	/**http调用
	 * 
	 * @param url :接口
	 * @param params :用户请求json参数
	 * @return 服务器返回内容
	 * @throws Exception
	 */
	public static String test(String url,String params) throws Exception {
		
		return HttpUtil.doPost(URL+url, params);
	}
}
