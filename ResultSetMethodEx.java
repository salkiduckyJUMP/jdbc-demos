package com.collabera.jdbc;
import java.sql.*;

public class ResultSetMethodEx {
    
    static final String URL = "jdbc:mysql://localhost:3306/sakila";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    
    public static Connection getConnection() {
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection was made.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public static void main(String[] args) {
        
        Connection conn = ResultSetMethodEx.getConnection(); // its static
    
        try {
            Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String query = "SELECT * FROM staff";
              ResultSet rs = stmt.executeQuery(query);
              
              while(rs.next()) {
                  String fn = rs.getString("first_name");
                  String ln = rs.getString("last_name");
                  int id = rs.getInt(1);
                  String email = rs.getString("email");
                  System.out.println(id+" "+fn+ " " + ln + " " + email);
              }
              stmt.close();
                System.out.println("statement was closed.");
            conn.close();
            System.out.println("connection was closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
