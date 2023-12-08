package com.controller;

import java.util.Scanner;

public class Controller {
	static AdminController ac = new AdminController();
	static CustomerController cs = new CustomerController();
	
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome To The Laptop Rentals");
			System.out.println("1 - Admin");
			System.out.println("2 - Customer");
			System.out.println("3 - Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println("Enter the password");
				String password = sc.nextLine();
				if(password.equals(ac.adminPassword)) {
					ac.adminMenuController();	
				} else {
					System.out.println("Incorrect Password, Please Try Again");
					break;
				}
				break;
			case 2: 
				cs.viewProducts();
				cs.customerMenuController();
				System.out.println("Under Developement, Thank You For Your Patience");
				break;
			case 3: 
				System.out.println("Exiting Program , Thank You For Your Service");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option Please Try Again");
				break;
			}
			
		}
		
	}
}
