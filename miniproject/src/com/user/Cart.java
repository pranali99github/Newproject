package com.user;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	
	 Scanner sc = new Scanner(System.in);
	 ArrayList<Integer> al1 = new ArrayList<>();
	 ArrayList<Integer> al2 = new ArrayList<>();
	 
	 public static int productQuantity;
	 public static int productID;
	 
	 public void getQuantityByUser(int product_id) {
			System.out.println("Enter the quantity : ");
			int quantity=sc.nextInt();
			
			addToCart(product_id,quantity);
	 }
	
	public void addToCart(int productId,int quantity) {
		
		productID=productId;
		productQuantity=quantity;
		
		storeItem(productId,quantity);
		
		System.out.println();
	
	}
	
	public void storeItem(int productId,int quantity) {
		
		al1.add(productId);
		al2.add(quantity);
		System.out.println("Item Added To The Cart !!!");
		cartOptions(productId,quantity);
		
		
		
	}
		
		public void cartOptions(int productId,int quantity) {

		System.out.println("1] Add More Items");
		System.out.println("2] Buy Now");
		
		int a=sc.nextInt();
		
		if(a==1) {
			User user = new User();
			user.productList();
		}
		else if(a==2) {
			BuyProducts bp = new BuyProducts();
			
			for(int i=0;i<al1.size();i++) {
			bp.buyProduct(productId,quantity);
		}
			System.out.println("Purchased Successfully!!!");
		}
		else {
			System.out.println("Please Choose Correct Option!!!");
			cartOptions(productId,quantity);
		}
		
		
		
		
	}

}
