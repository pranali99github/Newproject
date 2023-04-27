package com.login;

import java.util.Scanner;

import com.admin.AdminVerification;
import com.guest.Guest;
import com.user.User;

public class Main {
	
	public void welcome(){
		System.out.println("Welcome to E-Commerce");
			
			System.out.println("How do you want to continue ? ");
			selectOptions();
		}
		public void selectOptions() {
			
			Scanner sc = new Scanner(System.in);

			System.out.println("1] ADMIN");
			System.out.println("2] USER");
			System.out.println("3] GUEST");
			
			int option=sc.nextInt();
			authentication(option);
		}
		
		private void authentication(int option){
			
			if(option == 1) {
				AdminVerification adm = new AdminVerification();
				adm.adminVerification();
			}
			else if (option==2) {
				User user = new User();
				user.userOption();
			}
			else if (option==3) {
				Guest guest = new Guest();
				guest.getProductList();
			}
			else {
				System.out.println("Please Choose Correct Option");
				selectOptions();
			}
		}
		
		public static void main(String[] args) {
			Main login = new Main();
			login.welcome();

		}
		

}
