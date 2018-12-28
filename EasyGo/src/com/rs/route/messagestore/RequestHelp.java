package com.rs.route.messagestore;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rs.app.api.CheckSumBuilder;
import com.rs.properties.util.Basic;
/**验证消息抄送是否被篡改
 * 
 * @author wcs
 *
 */
public class RequestHelp {
	public static final Logger logger = LoggerFactory
            .getLogger(MessageStore.class);
	private final static String appSecret = Basic.appSecret;
	public static boolean verify(HttpServletRequest request){
		
		boolean ret = false;
		
		ret = true;
		
		byte[] body = readBody(request);
		
        if (body == null) {
            logger.warn("request wrong, empty body!");
            return ret;
        }
		String ContentType = request.getContentType();
        String AppKey = request.getHeader("AppKey");
        String CurTime = request.getHeader("CurTime");
        String MD5 = request.getHeader("MD5");
        String CheckSum = request.getHeader("CheckSum");
        String requestBody = null;
		try {
			requestBody = new String(body, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String verifyMD5 = CheckSumBuilder.getMD5(requestBody);
//        System.out.println(MD5 +"?=" + verifyMD5);
       
        String verifyChecksum = CheckSumBuilder.getCheckSum(appSecret, verifyMD5, CurTime);
//        System.out.println(CheckSum+" ?= "+verifyChecksum);
        if(MD5.equals(verifyMD5) &&  CheckSum.equals(verifyChecksum))//判断被修改
        	ret = true;;
        return ret;
        
	}
	private static byte[] readBody(HttpServletRequest request) {
		System.out.println(request.getContentLength());
        if (request.getContentLength() > 0) {
            byte[] body = new byte[request.getContentLength()];
//            IOUtils.readFully(request.getInputStream(), body);
            return body;
        } else
            return null;
    }	
		
}
