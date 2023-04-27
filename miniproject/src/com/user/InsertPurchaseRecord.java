package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class InsertPurchaseRecord {

	public static int product_id;
	public static int quantity;
	
	public static void getInput(int customer_id,String product_name,int quantity,int unit_price) {
	
		insertPurchaseRecord(customer_id,product_name,quantity,unit_price);
	
	}
	
	public static void insertPurchaseRecord(int customer_id,String product_name,int quantity,int unit_price) {
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement ps=connection.prepareStatement("insert into purchase_records(customer_id,product_name,product_quantity,unit_price) values(?,?,?,?);");
			
			ps.setInt(1,customer_id);
			ps.setString(2,product_name);
			ps.setInt(3,quantity);
			ps.setInt(4,unit_price);
			
			ps.execute();
			
			
			}
	catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
	
//		InsertPurchaseRecord.getInput(customer_id,product_name,quantity,unit_price);
		
		
		
		
		
		
	}
}
