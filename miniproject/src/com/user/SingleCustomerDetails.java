package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class SingleCustomerDetails {

	private static int customerId;
	private static String firstname;
	private static String lastname;
	private static String username;
	private static String password;
	private static String city;
	private static String email;
	private static String phoneNumber;
	
	
	
	public static int getCustomerId() {
		return customerId;
	}
	public static String getFirstname() {
		return firstname;
	}
	public static String getLastname() {
		return lastname;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getCity() {
		return city;
	}
	public static String getEmail() {
		return email;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}

	public static void getSingleCustomer(int id) {
		
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
	
public static void getCustomerIdUsingUsername(String userName) {
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select id from customers where username=?");
			
			preparedStatement.setString(1, userName);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
			    customerId=resultSet.getInt(1);
//				firstname=resultSet.getString(2);
//				lastname=resultSet.getString(3);
//				username=resultSet.getString(4);
//				password=resultSet.getString(5);
//				city=resultSet.getString(6);
//				email=resultSet.getString(7);
//				phoneNumber=resultSet.getString(8);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		getCustomerIdUsingUsername("pushkar123");
		System.out.println(customerId);
//		System.out.println(firstname);
//		System.out.println(lastname);
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(city);
//		System.out.println(email);
//		System.out.println(phoneNumber);
	}
	
}
