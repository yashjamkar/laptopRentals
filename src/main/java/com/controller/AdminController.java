package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.entity.ProductsToRent;
import com.entity.Rentals;
import com.service.imp.AdminService;

public class AdminController {

	static AdminService as = new AdminService();
	
	protected String adminPassword = "admin123";

	public void addProduct(Integer pId, String pName, String pDescription) {
		try {
			as.addProduct(pId, pName, pDescription);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCustomer(Integer cId, String cName, String cPass) {
		try {
			as.addCustomer(cId, cName, cPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProductsToRent> viewProducts() {
        try {
            as.viewProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
    }
	
	public List<Rentals> viewRentalsById(Integer customerId){
		try {
			as.viewRentalsById(customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String updateRentalStatus(Integer rentalId, String newRentedStatus) {
		try {
			as.updateRentalStatus(rentalId, newRentedStatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void adminMenuController() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("What would you like to do?");
			System.out.println("1 - Add Product");
			System.out.println("2 - Add Customer");
			System.out.println("3 - View Products");
			System.out.println("4 - View Products Rented By The Customer");
			System.out.println("5 - Update The Rental Status");
			System.out.println("6 - Exit");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter the details of the product you want to add");
				System.out.println("Enter Product ID");
				Integer productId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Product Name");
				String productName = sc.nextLine();
				System.out.println("Enter Product Description");
				String productDescription = sc.nextLine();
				if(productId != 0 && productName != null && productDescription != null) {
					addProduct(productId, productName, productDescription);
				} else {
					System.out.println("Invalid Inputs , Please Enter Valid Details");
				}
				
				break;

			case 2: 
				System.out.println("Enter the details of the customer you want to add");
				System.out.println("Enter Customer ID");
				Integer customerId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Customer Name");
				String customerName = sc.nextLine();
				
				System.out.println("Enter Customer Password");
				String customerPassword = sc.nextLine();
				if(customerId != 0 && customerName != null && customerPassword != null) {
					addCustomer(customerId, customerName, customerPassword);
				} else {
					System.out.println("Invalid Inputs , Please Enter Valid Details");
				}
				
				break;
			case 3: 
				viewProducts();
				break;
			case 4:
				System.out.println("Enter the Customer Id");
				Integer customerId1 = sc.nextInt();
				viewRentalsById(customerId1);
//				System.out.println("Under Developement, Thank you for your patience");
				break;
			case 5: 
				System.out.println("Enter the Rental ID whose status you want to change");
				Integer rId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the code for changing status");
				String newRentedStatus = sc.nextLine();
				updateRentalStatus(rId, newRentedStatus);
//				System.out.println("Exiting Program , Thank you for your service");
				break;
			case 6: 
				System.out.println("Exiting Program , Thank you for your service");
				return;
			default:
				System.out.println("Invalid Option Please Try Again");
				break;
			}
			
		}
	}

}
