package com.collabera.jdbc;

import java.sql.*;

public class PreparedStatementsEx {
	
	static final String URL = "jdbc:mysql://localhost:3306/sakila";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was created!");
			
			PreparedStatement ptsmt = conn.prepareStatement(
					" select * from sakila.actor where first_name = ? ");
			
			ptsmt.setString(1, "sissy");
			
			ResultSet rs = ptsmt.executeQuery();
			
			while(rs.next()) {
				System.out.println( rs.getString("first_name") );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = PreparedStatementsEx.getConnection();
		
		//we did some stuff here

		
		try {
			conn.close();
			System.out.println("Connection was closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
