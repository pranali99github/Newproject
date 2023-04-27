package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class RegisteredUser {

	public void getAllRegisteredUser() {
		for(int i=1;i<=4;i++) {
		getRegisteredUserDetails(i);
		}
	}
	public void getParticularRegisteredUser(int id) {
		
		getRegisteredUserDetails(id);
		
	}
	
	
	public void getRegisteredUserDetails(int id){
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from customers where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
			    int Id=resultSet.getInt(1);
				String firstname=resultSet.getString(2);
				String lastname=resultSet.getString(3);
				String username=resultSet.getString(4);
				String password=resultSet.getString(5);
				String city=resultSet.getString(6);
				String email=resultSet.getString(7);
				String phoneNumber=resultSet.getString(8);
				
				System.out.println("ID : "+ Id);
				System.out.println("firstname : "+firstname);
				System.out.println("lastname : "+lastname);
				System.out.println("username : "+username);
				System.out.println("password : "+password);
				System.out.println("city : "+city);
				System.out.println("email : "+email);
				System.out.println("phoneNumber : "+phoneNumber);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
}
	
	
	public void getRegisteredName(){
		for(int i=1;i<=4;i++) {
		getRegisteredUserName(i);
		}
	}
	
public void getRegisteredUserName(int id){
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from customers where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
			    int Id=resultSet.getInt(1);
				String firstname=resultSet.getString(2);
				String lastname=resultSet.getString(3);
				String username=resultSet.getString(4);
				String password=resultSet.getString(5);
				String city=resultSet.getString(6);
				String email=resultSet.getString(7);
				String phoneNumber=resultSet.getString(8);
				
				System.out.println(Id+"] "+firstname+" "+lastname);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
}
	public static void main(String[] args) {
		
		RegisteredUser ru = new RegisteredUser();
		ru.getAllRegisteredUser();
	}
}
