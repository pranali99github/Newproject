package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class ShowPurchaseHistory {
	
	private static String firstname;
	private static String lastname;
	private static int purchase_Id;
	private  static int customer_Id;
	private static String product_name;
	private static int product_quantity;
	private static int unit_price;
	private static int totalBill;
	
	public static String getFirstName() {
		return firstname;
	}
	public static String getLastName() {
		return lastname;
	}
	public static int getPurchaseId() {
		return purchase_Id;
	}
	public static int getCustomerId() {
		return customer_Id;
	}
	public static String getProduct_Name() {
		return product_name;
	}
	public static int getProductQuantity() {
		return product_quantity;
	}
	public static int getUnitPrice() {
		return unit_price;
	}
	public static int getTotalBill() {
		return totalBill;
	}

	
	
	public void getPurchaseHistory(int purchase_id){
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select firstname,lastname,purchase_id,customer_id,product_name,product_quantity,unit_price,product_quantity*unit_price as total from purchase_records as pr join customers as c on pr.customer_id=c.id where purchase_id=?");
			
			preparedStatement.setInt(1, purchase_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				firstname=resultSet.getString(1);
				lastname=resultSet.getString(2);
			    purchase_Id=resultSet.getInt(3);
				customer_Id=resultSet.getInt(4);
				product_name=resultSet.getString(5);
				product_quantity=resultSet.getInt(6);
				unit_price=resultSet.getInt(7);
				totalBill=resultSet.getInt(8);

			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	

}
