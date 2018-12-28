package com.rs.mysql.controll;

import javax.sql.DataSource;

public class MysqlInit {
	private com.tonetime.commons.database.Configuration configure   = null;
	private com.tonetime.commons.database.DataSourceBuilder builder = null;
	
	DataSource masterSource=null;
	DataSource slaveSource=null;
	private MysqlInit(){
		configure = new com.tonetime.commons.database.Configuration("db.properties");
		builder   = com.tonetime.commons.database.DataSourceBuilder.builder(configure);
		
		masterSource=builder.getDataSource("dbMaster");
		slaveSource =builder.getDataSource("dbSlave");
		
	}
	
	private static class HolderSingleton{
		static MysqlInit instance = new MysqlInit();
	}
	
	public static MysqlInit getInstance(){
		return HolderSingleton.instance;
	}
	
	public DataSource getMasterSource(){
		return masterSource;
	}
	public DataSource getSlaveSource(){
		return slaveSource;
	}
}
