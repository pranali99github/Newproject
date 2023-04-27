package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class UserHistory {
	public void getParticularUserHistory(int customer_id){
		getUserHistory(customer_id);
	}
	
	public void getUserHistory(int customer_id){
	
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select firstname,lastname,purchase_id,customer_id,product_name,product_quantity,unit_price,product_quantity*unit_price as total from purchase_records as pr join customers as c on pr.customer_id=c.id where customer_id=?");
			
			preparedStatement.setInt(1, customer_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String firstname=resultSet.getString(1);
				String lastname=resultSet.getString(2);
			    int purchase_Id=resultSet.getInt(3);
				int customer_Id=resultSet.getInt(4);
				String product_name=resultSet.getString(5);
				int product_quantity=resultSet.getInt(6);
				int unit_price=resultSet.getInt(7);
				int totalBill=resultSet.getInt(8);
			
				System.out.println("Purchase ID : "+ purchase_Id);
				System.out.println("Customer ID : "+customer_Id);
				System.out.println("firstname : "+firstname);
				System.out.println("lastname : "+lastname);
				System.out.println("Product Name : "+product_name);
				System.out.println("Purchase Quantity : "+product_quantity);
				System.out.println("Unit Price : "+unit_price);
				System.out.println("Total Bill : "+totalBill);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	
	
	public void getAllPurchaseHistory(){
		for(int i=1;i<=4;i++) {
		getPurchaseHistory(i);
	}
	}
	
	public void getPurchaseHistory(int purchase_id){
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select firstname,lastname,purchase_id,customer_id,product_name,product_quantity,unit_price,product_quantity*unit_price as total from purchase_records as pr join customers as c on pr.customer_id=c.id where purchase_id=?");
			
			preparedStatement.setInt(1, purchase_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String firstname=resultSet.getString(1);
				String lastname=resultSet.getString(2);
			    int purchase_Id=resultSet.getInt(3);
				int customer_Id=resultSet.getInt(4);
				String product_name=resultSet.getString(5);
				int product_quantity=resultSet.getInt(6);
				int unit_price=resultSet.getInt(7);
				int totalBill=resultSet.getInt(8);
			
				System.out.println("Purchase ID : "+ purchase_Id);
				System.out.println("Customer ID : "+customer_Id);
				System.out.println("firstname : "+firstname);
				System.out.println("lastname : "+lastname);
				System.out.println("Product Name : "+product_name);
				System.out.println("Purchase Quantity : "+product_quantity);
				System.out.println("Unit Price : "+unit_price);
				System.out.println("Total Bill : "+totalBill);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	
	
	
public static void main(String[] args) {
	UserHistory uh = new UserHistory();
	uh.getAllPurchaseHistory();
}
}
