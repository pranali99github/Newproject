package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.extra.CommonConnection;

public class Registeration {

	
	private static String firstname;
	private static String lastname;
	private static String username;
	private static String password;
	private static String city;
	private static String email;
	private static String phoneNumber;
	
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	
	public static void getDetails(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your First Name : ");
		firstname=sc.next();
		System.out.println("Enter Your Last Name : ");
		lastname=sc.next();
		System.out.println("Enter Your Username : ");
		username=sc.next();
		System.out.println("Enter Your Password : ");
		password=sc.next();
		System.out.println("Enter Your City : ");
		city=sc.next();
		System.out.println("Enter Your Email : ");
		email=sc.next();
		System.out.println("Enter Your Phone Number : ");
		phoneNumber=sc.next();
		
		insertNewRegisteration();
		
	}
	
	public static void insertNewRegisteration() {
		
		try {
			
			Connection con=CommonConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into customers(firstname,lastname,username,passwd,city,email,phoneNumber)values(?,?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, email);
			ps.setString(7, phoneNumber);
			
			ps.execute();
			System.out.println();
			System.out.println("Registeration Successful!!!");
			System.out.println();
			
			UserLogin.getNewRegisteredInput(username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		getDetails();
		
	}
	
	
}
