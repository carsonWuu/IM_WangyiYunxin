package com.rs.mysql.controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rs.util.bean.ReqBean;
import com.tonetime.commons.database.helper.DbHelper;
import com.tonetime.commons.database.helper.JdbcCallback;

/**数据库存储操作类
 * 
 * @author wcs
 *
 */
public class MysqlControll {
	
	public static boolean store(final ReqBean reqBean){
		
		System.out.println("数据库存储");
		
		int n = 0;	
		try {
			n =(int) DbHelper.execute(MysqlInit.getInstance().getMasterSource(),
					new JdbcCallback() {

						@Override
						public Object doInJdbc(Connection arg0)
								throws SQLException, Exception {
							
							final String sqlCom = "insert into message(c_eventType,c_convType) values(?,?)";
							PreparedStatement cs = arg0.prepareStatement(sqlCom);
							cs.setObject(1, reqBean.getEventType());
							cs.setObject(2, reqBean.getConvType());
							int n = cs.executeUpdate();
							return n;
						}
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		finally{
			
			return n==1;
		}
	}
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MysqlControll.class);
		logger.info("hh");
		
		ReqBean reqBean = new ReqBean();
		reqBean.setEventType("1");
		reqBean.setConvType("PERSON");
		store(reqBean);
		
	}
}
