package com.rs.method;

import com.rs.store.message.Message;
import com.rs.storebyeventType.StoreInter;
import com.rs.util.bean.ReqBean;

/**消息抄送类型及对应方法调用
 * 
 * @author wcs
 *
 */
public class Methods {
	public static boolean store(ReqBean reqBean) {
		String eventType = reqBean.getEventType();
		switch(eventType) {
		case "1"://会话类型的消息：p2p聊天消息、群组聊天消息、群组操作、好友操作
			StoreInter store = new Message();
			boolean bool = store.store(reqBean);
			System.out.println("保存结果："+bool);
			break;
		case "2"://用户登录事件的消息
			
			break;
		case "3"://用户登出事件的消息
			break;
		case "4"://聊天室中聊天的消息
			break;
			
			
		case "5":
			break;
		case "6":
			break;
		case "7":
			break;
		case "8":
			break;
		case "9":
			break;
		case "10":
			break;
		case "11":
			break;
		case "12":
			break;
		case "13":
			break;
		case "14":
			break;
		default:
			break;
			
		}
		return true;
	}
}
