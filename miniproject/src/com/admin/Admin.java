package com.admin;

import java.util.Scanner;

public class Admin {
	
	Scanner sc = new Scanner(System.in);
	
	
	public void getAdminOptions(){
		
		System.out.println("1] Add Product Item");
		System.out.println("2] Calculate Bill");
		System.out.println("3] Display Amount to End User");
		System.out.println("4] Check Quantity");
		System.out.println("5] Check Registered User");
		System.out.println("6] Check the Particular User History\n");
		
		System.out.println("Please Choose Your Option :");
		
		int op= sc.nextInt();
	if(op==1 || op==2 || op==3 || op==4 || op==5 || op==6) {
		selectOption(op);
	}
	else {
		System.out.println("Please Choose Correct Option!!!");
		getAdminOptions();
	}
	}
	public void selectOption(int op) {
		if(op==1) {
			addProductItem();
		}
		else if(op==2) {
			calculateBill();
		}
		else if(op==3) {
			showTotalAmountToUser();
		}
		else if(op==4) {
			checkQuantity();
		}
		else if(op==5) {
			checkRegisteredUser();
		}
		else if(op==6) {
			checkParticularUserHistory();
		}
		else {
			System.out.println("Please Choose Correct Option !!!");
			selectOption(op);
		}
	}
	
		
	
	public void addProductItem(){
	InsertSingleProduct.insertSingleProduct();
	}
	
	public void calculateBill() {
		
	}
	
	public void showTotalAmountToUser() {
		
		System.out.println(ShowPurchaseHistory.getTotalBill());
	}
	
	public void checkQuantity() {
		ProductQuantityDetails.getAllProductQuantity();
	}
}
