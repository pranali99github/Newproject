package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.extra.CommonConnection;

public class UserLogin {

	private static String username;
	private static String password;


	static int count=16;
	
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	public static void getLoginInput() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username : ");
		String userName=sc.next();
		System.out.println("Enter Password : ");
		String pass=sc.next();
		
		userLogin(userName,pass);
		
	}
	
	public static void getNewRegisteredInput(String regUserName,String regPassWord) {
		String regUsername=regUserName;
		String regPassword=regPassWord;
		count++;
		userLogin(regUsername,regPassword);
	}
	
	public static void userLogin(String userName,String pass) {
		
		username=userName;
		password=pass;
		
		for(int i=1;i<=count;i++) {
		getCustomerDetails(i);
		userVerify(userName,pass);
		}

	}
	
		public static void registerationNotFound() {
		System.out.println("1] Try Again");
		System.out.println("2] Go To Registeration");
		
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		
		if(num==1) {
			getLoginInput();
		}
		else if(num==2) {
			Registeration.getDetails();
		}
		else {
			System.out.println("Please Choose Correct Option!!!");
			System.out.println();
			registerationNotFound();
		}
	}
	
	public static void userVerify(String userName,String pass) {
		
		if(getUsername().equals(userName) && (getPassword().equals(pass))){
			
			System.out.println("Login Successful!!!");
			System.out.println();
			
			User user= new User();
			user.productList();
		}
	}
	
	public static void getCustomerDetails(int id) {
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select username,passwd from customers where id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			
				username=resultSet.getString(1);
				password=resultSet.getString(2);

			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		getLoginInput();
		
	}
	
}
