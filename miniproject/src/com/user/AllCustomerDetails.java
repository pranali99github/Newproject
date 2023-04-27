package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class AllCustomerDetails {

	static int customerId;
	static String firstname;
	static String lastname;
	static String username;
	static String password;
	static String city;
	static String email;
	static String phoneNumber;
	
	public static void getAllRecords(int id) {
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from customers where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
			    customerId=resultSet.getInt(1);
				firstname=resultSet.getString(2);
				lastname=resultSet.getString(3);
				username=resultSet.getString(4);
				password=resultSet.getString(5);
				city=resultSet.getString(6);
				email=resultSet.getString(7);
				phoneNumber=resultSet.getString(8);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		for(int i=1;i<2;i++) {
		getAllRecords(i);
		System.out.println(customerId);
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(username);
		System.out.println(password);
		System.out.println(city);
		System.out.println(email);
		System.out.println(phoneNumber);
		}
		}

}
