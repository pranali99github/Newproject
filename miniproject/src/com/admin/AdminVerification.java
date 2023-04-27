package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.extra.CommonConnection;

public class AdminVerification {
	public void adminVerification() {
		fetchAdminInfo(1);
	}
	
	public void fetchAdminInfo(int id){
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from admin_info where id=?");

			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int ID=resultSet.getInt(1);
				String username=resultSet.getString(2);
				String passwd=resultSet.getString(3);
				
//				System.out.println("username :"+username +"\n Password : "+passwd );
				
				adminLoginVerification(username,passwd);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void adminLoginVerification(String username,String password){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Admin ID : ");
		String adminId=sc.next();
		System.out.println("Enter Your Admin Password : ");
		String adminPassword=sc.next();
		
		if(username.equals(adminId) && password.equals(adminPassword)) {
			System.out.println("You Successfully Logged In !!");
			Admin adm = new Admin();
			adm.getAdminOptions();
		}
		
	}

}
