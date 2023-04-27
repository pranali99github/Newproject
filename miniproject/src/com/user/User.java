package com.user;

import java.util.Scanner;

public class User {

Scanner sc = new Scanner(System.in);
	
	public void userOption(){
		System.out.println("1] Register");
		System.out.println("2] Login");
		
		int op=sc.nextInt();
		
		if(op==1) {
		register();
		}
		else if(op==2) {
			login();
		}
		else {
			System.out.println("Please Choose Correct Option!!!");
			userOption();
		}
	}

	private void register() {
		Registeration.getDetails();
	}
	
	private void login() {
		UserLogin.getLoginInput();
	}
		
	public void productList() {
			Product.getAllProducts();
			System.out.println();
			System.out.println("Select Product To Continue : ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			
			BuyProducts bp = new BuyProducts();
			bp.viewProducts(num);
			
		}
	
	public void viewCart() {
		
	}
	
	public static void main(String[] args) {
		User u = new User();
//		u.viewProducts(1);
	}
	
	
}
