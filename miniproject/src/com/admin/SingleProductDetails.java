package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class SingleProductDetails {

	static int Id;
	static String description;
	static String name;
	static int quantity;
	static int unit_price;
	
	public static void getSingleProduct(int id) {
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from products where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
			    Id=resultSet.getInt(1);
				description=resultSet.getString(2);
				name=resultSet.getString(3);
				quantity=resultSet.getInt(4);
				unit_price=resultSet.getInt(5);
				

			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		getSingleProduct(1);
		System.out.println(Id);
		System.out.println(name);
		System.out.println(description);
		System.out.println(quantity);
		System.out.println(unit_price);
	}
}
