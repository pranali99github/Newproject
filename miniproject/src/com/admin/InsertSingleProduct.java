package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.extra.CommonConnection;

public class InsertSingleProduct {
	
	public static void insertSingleProduct() {
		try {	
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter Description>>>");
		String description=sc1.nextLine();
		
		System.out.println("Enter Name>>>");
		String name= sc1.nextLine();
		
		System.out.println("Enter Quantity>>>");
		int quantity = sc1.nextInt();
		
		System.out.println("Enter Price>>>");
		int unit_price = sc1.nextInt();
		
		sc1.close();
		
	Connection con = CommonConnection.getConnection();
	PreparedStatement ps = con.prepareStatement("insert into products(description, name, quantity, unit_price) values(?,?,?,?);");
	

	ps.setString(1, description);
	ps.setString(2, name);
	ps.setInt(3, quantity);
	ps.setInt(4, unit_price);

	ps.execute();
	
	System.out.println("Product Added Successfully!!!");
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		insertSingleProduct();
	}
}
