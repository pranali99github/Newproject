package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.extra.CommonConnection;

public class UpdateProductQuantity {

public static void getQuantityByUser(int quantityByUser,int product_id){
		
		SingleProductDetails.getSingleProduct(product_id);
		int totalQuantity = SingleProductDetails.getQuantity();
		
		int newProductQuantity=totalQuantity-quantityByUser;
		
		updateProductTotalQuantity(newProductQuantity,product_id);
	}

	public static void updateProductTotalQuantity(int newProductQuantity,int product_id){
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement ps=connection.prepareStatement("update products set quantity=? where id="+product_id);
			
			ps.setInt(1,newProductQuantity);

			ps.execute();
			
			}
	catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
