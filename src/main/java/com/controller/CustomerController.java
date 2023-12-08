package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.entity.ProductsToRent;
import com.entity.Rentals;
import com.service.imp.AdminService;
import com.service.imp.CustomerService;

public class CustomerController {
	
	static CustomerService cs = new CustomerService();
	static AdminService as = new AdminService();
	
	public void rentAProduct(Integer cId, Integer pId) {
		try {
			cs.rentAProduct(cId, pId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductsToRent> viewProducts(){
		try {
			as.viewProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Rentals> viewRentalStatus(Integer customerId){
		try {
			cs.viewRentalStatus(customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void customerMenuController() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("What would you like to do?");
			System.out.println("1 - I Would Like To Rent A Laptop");
			System.out.println("2 - Check Rental Status");
			System.out.println("3 - Exit");
			
			int choice = sc.nextInt();
			
			
			switch (choice) {
			case 1:
				System.out.println("Enter your Customer ID");
				int CustomerID = sc.nextInt();
			
				
				System.out.println("Enter the ID of the Laptop you'd like to rent ");
				int ProductId = sc.nextInt();
				
				rentAProduct(CustomerID, ProductId);
				break;
			case 2: 
				System.out.println("Enter Your Customer ID");
				int CustomerIDForCheckingRentalStatus = sc.nextInt();
				viewRentalStatus(CustomerIDForCheckingRentalStatus);
			case 3: 
				System.out.println("Thank You For Your Patronage");
				return;
			default:
				System.out.println("Invalid Option, Please Try Again");
				break;
			}
		}
	}
	
}
