package com.collabera.jdbc;

import java.sql.*;

public class ConnectionManager {
	static final String URL = "jdbc:mysql://localhost:3306/testdb";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was created!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionManager.getConnection();
		
		//we did some stuff here

		
		try {
			conn.close();
			System.out.println("Connection was closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
