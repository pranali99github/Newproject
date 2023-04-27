package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class Product {
	
	public static void getSingleProduct(int id) {
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from products where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int Id=resultSet.getInt(1);
				String description=resultSet.getString(2);
				String name=resultSet.getString(3);
				int quantity=resultSet.getInt(4);
				int price=resultSet.getInt(5);
				
				System.out.println(Id+"] "+name+" : "+description);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getAllProducts() {
		for(int i=1;i<=10;i++) {
		fetchRecords(i);
	}
	}
	public static void fetchRecords(int id) {
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from products where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int Id=resultSet.getInt(1);
				String description=resultSet.getString(2);
				String name=resultSet.getString(3);
				int quantity=resultSet.getInt(4);
				int price=resultSet.getInt(5);
				
				System.out.println(Id+"] "+"Name : "+name);
				System.out.println(" Description : "+description +"       Price : "+price+"\u20B9");
				System.out.println();
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getAllProducts();
	}

}
