package com.collabera.jdbc;

import java.sql.*;

public class ResultMetaDataEx {
	static final String URL = "jdbc:mysql://localhost:3306/sakila";
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
		Connection conn = ResultMetaDataEx.getConnection();
		
		//we did some stuff here

		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from actor");
			
			ResultSetMetaData metadata = rs.getMetaData();
			
			int numberOfColumns = metadata.getColumnCount();
			
			
			for(int i = 1; i <= numberOfColumns; i++) {
				
				String name = metadata.getColumnName(i);
				int columntype = metadata.getColumnType(i);
				String columntype2 = metadata.getColumnTypeName(i);
				
				System.out.println("\n" + name);
				System.out.println(columntype);
				System.out.println("Column Type Name: " + columntype2);
			}
			
			conn.close();
			System.out.println("Connection was closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
