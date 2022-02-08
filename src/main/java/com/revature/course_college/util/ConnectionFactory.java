package com.revature.course_college.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {

	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private Properties properties = new Properties();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory() {
		try {
			properties.load(new FileReader("src/main/resources/db.properties"));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			String url = properties.getProperty("url");
			String admin = properties.getProperty("admin");
			String password = properties.getProperty("password");
			connection = DriverManager.getConnection(url, admin, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
