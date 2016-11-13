package com.even.velocity.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
	
	private static DbConnection dbConnection = null;
	private Properties prop = new Properties();
	private DbConnection(){
		init();
	}
	
	public synchronized static DbConnection getInstance(){
		if(dbConnection == null){
			dbConnection = new DbConnection();
		}
		return dbConnection;
	}
	
	private void init(){
		InputStream in = null;
		try {
			in = getClass().getResourceAsStream("/application/dbConfig.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			String connectionType = prop.getProperty("connection");
			if("mysql".equals(connectionType)){
				conn = this.getMysqlConnection();
			}else if("oracle".equals(connectionType)){
				conn = this.getOracleConnection();
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	public Connection getMysqlConnection(){
		Connection conn = null;
		try {
			String userName = prop.getProperty("mysql.username");
			String password = prop.getProperty("mysql.password");
			String url = prop.getProperty("mysql.url");
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	public Connection getOracleConnection(){
		Connection conn = null;
		try {
			String userName = prop.getProperty("username");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userName, password);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return conn;
	}
	
	

}
