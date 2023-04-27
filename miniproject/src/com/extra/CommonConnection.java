package com.extra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonConnection {
	
	
	
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-shop","root","admin");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
