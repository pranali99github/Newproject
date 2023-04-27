package com.user;

import java.util.Scanner;

import com.admin.SingleProductDetails;

public class BuyProducts {
	public static int product_id;
	Scanner sc = new Scanner(System.in);
	public void viewProducts(int num) {
		
		product_id=num;
		
		SingleProductDetails.getSingleProduct(product_id);
		System.out.println("Product Name : "+SingleProductDetails.getId());
		System.out.println("Description : "+SingleProductDetails.getDescription());
		System.out.println("Unit Price : "+SingleProductDetails.getUnitPrice());
		System.out.println();
		
		System.out.println("1] Buy");
		System.out.println("2] Add to Cart");
		System.out.println("3] Go Back");
		System.out.println();
		System.out.println("Enter Your Option : ");
		
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		if(input==1) {
			getQuantity(num);
		}
		else if(input==2) {
			Cart cart = new Cart();
			cart.getQuantityByUser(product_id);
		}
		else if(input==3) {
			User user = new User();
			user.productList();
		}
		else {
			System.out.println("Please Choose Correct Option!!!");
			viewProducts(product_id);
		}
	}
	
	public void buyProduct(int product_id,int quantity) {
		
		int customerId=getCustomerId();
		String productName=getProductName();
		int unitPrice = getUnitPrice();
		UpdateProductQuantity.getQuantityByUser(quantity,product_id);
		InsertPurchaseRecord.getInput(customerId,productName,quantity,unitPrice);

	}
	
	public int getCustomerId() {
		SingleCustomerDetails.getCustomerIdUsingUsername(UserLogin.getUsername());
		int id=SingleCustomerDetails.getCustomerId();
		return id;
	}
	public String getProductName() {
		SingleProductDetails.getSingleProduct(product_id);
		String productName = SingleProductDetails.getName();
		return productName;
	}
	public void getQuantity(int product_id) {
		System.out.println("Enter the quantity : ");
		int quantity=sc.nextInt();
		buyProduct(product_id,quantity);
	}
	
	public int getUnitPrice() {
		SingleProductDetails.getSingleProduct(product_id);
		int unitPrice = SingleProductDetails.getUnitPrice();
		
		return unitPrice;
	}
	
	
	
	

}
