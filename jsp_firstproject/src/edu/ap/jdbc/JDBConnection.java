package edu.ap.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
	
	private static JDBConnection instance = null;
	private Connection conn = null;
	
	private JDBConnection() {
		System.out.println("Instantiated");
	}
	
	public static synchronized JDBConnection getJDBConnection() {
		if(instance == null) {
			instance = new JDBConnection();
		}
		return instance;
	}
	
	public void openConnection(String database, String user, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.driver");
			String url = "jdbc:mysql://127.0.0.1/" + database;
			conn= DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection opened");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
			System.out.println("connection closed");
		} catch (Exception e) {
			System.out.println(e);
		}
	};

}
