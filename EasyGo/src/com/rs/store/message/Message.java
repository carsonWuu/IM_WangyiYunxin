package com.rs.store.message;

import com.rs.mysql.controll.MysqlControll;
import com.rs.storebyeventType.StoreInter;
import com.rs.util.bean.ReqBean;

/**会话消息存储
 * 
 * @author wcs
 *
 */
public class Message implements StoreInter{
	
	@Override
	public boolean store(ReqBean reqBean) {
		// TODO Auto-generated method stub
		return MysqlControll.store(reqBean);
		
	}

}
