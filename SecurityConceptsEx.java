package com.collabera.jdbc;
import java.sql.*;
import java.util.Scanner;



public class SecurityConceptsEx {
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
	
	public static void main(String[] args) throws SQLException {
		Connection conn = SecurityConceptsEx.getConnection();
		
		Statement state = conn.createStatement();
		
		//we did some stuff here
		Scanner sc = new Scanner(System.in);
		System.out.println("Type name of the city you are looking for: ");
		String name = sc.nextLine();
		sc.close();
		//String query = String.format("SELECT * from city where name = '%s' ", name);
		
		String query = String.format("SELECT * from city where name = 'x' or 'a'='a' ", name);
		
		ResultSet rs = state.executeQuery(query);
		
		System.out.println(query);
		

		
		try {
			conn.close();
			System.out.println("Connection was closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
