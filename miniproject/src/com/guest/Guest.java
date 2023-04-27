package com.guest;

import java.util.Scanner;

import com.user.Product;

public class Guest {

public void getProductList(){
		
		Product.getAllProducts();
		
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		
	}
	
	
	public static void main(String[] args) {
		
	
		Guest g = new Guest();
		g.getProductList();
		
		
	
}
}
