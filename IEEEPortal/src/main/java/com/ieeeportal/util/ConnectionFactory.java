package com.ieeeportal.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class ConnectionFactory {
	
	static Connection connection = null;
	
	public static Connection getConnection(){
		if(connection != null){
			return connection;
		}else{
			try{
				 Properties properties = new Properties();
				 InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
				 properties.load(inputStream);
				 String DRIVER = properties.getProperty("driver");
				 String URL = properties.getProperty("url");
			     String DB_NAME = properties.getProperty("dbname");
			     String USER_NAME = properties.getProperty("username");
			     String PASSWORD = properties.getProperty("password");
			     String URL_DBNAME = URL + DB_NAME;
			        
			     connection = getConnection(DRIVER, URL_DBNAME, USER_NAME, PASSWORD);
			  }catch(IOException ie){
				  System.out.print(ie.getMessage());
			  }
			}
		  return connection;
		}

 
    private static Connection getConnection(String driver_name, String url, String user_name, String password){
	
	try{
		Class.forName(driver_name);
		connection = DriverManager.getConnection(url, user_name, password);
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.print("Connection established!");
	return connection;
}


}
