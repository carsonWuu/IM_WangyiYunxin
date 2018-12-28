package com.rs.properties.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.rs.app.api.CheckSumBuilder;

public class GetToken {
	public static String getToken(String accid,String url) {
		HttpClient httpClient = new DefaultHttpClient();
        
        HttpPost httpPost = new HttpPost(url);

        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(Basic.appSecret, Basic.nonce ,curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", Basic.appKey);
        httpPost.addHeader("Nonce", Basic.nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", accid));
        try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // 执行请求
        HttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // 打印执行结果
		String retJson = null;
		try {
			retJson = new String(EntityUtils.toString(response.getEntity(), "utf-8"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return retJson;
		}
        
        
	}
	
	public static void main(String[] args) {
		String url = Basic.refreshURL;
		String json = GetToken.getToken("helloworld",url);
		System.out.println(json);
	}
}
