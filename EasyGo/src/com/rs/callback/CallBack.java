package com.rs.callback;

import com.rs.properties.util.Basic;
import com.rs.util.bean.ReqBean;

public class CallBack {
	public static boolean IsCallBack(ReqBean reqBean) {
		if(Basic.cancallback==1) {//不允许执行
			return false;
		} else if(Basic.cancallback==0) {//允许执行
			return true;
		} else {//判断是否允许执行
			
			
			return true;
		}
		
		
		
	}
}
