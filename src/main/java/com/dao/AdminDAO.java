package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.entity.ProductsToRent;
import com.entity.Rentals;

public class AdminDAO {
	public String addProduct(Integer pId, String pName, String pDescription) throws SQLException{
		String query = "INSERT INTO ITEMFORRENT VALUES(" + pId + ",'" + pName + "','" + pDescription + "')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalshopdb", "root", "placeholder");
		PreparedStatement pst = con.prepareStatement(query);
		pst.execute();
		con.close();
		
		return "Product Added";
	}
	
	public String addCustomer(Integer cId, String cName, String cPass) throws SQLException{
		String query = "INSERT INTO CUSTOMERS VALUES(" + cId + ",'" + cName + "','" + cPass + "')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalshopdb", "root", "placeholder");
		PreparedStatement pst = con.prepareStatement(query);
		pst.execute();
		con.close();
		
		return "Customer Added";
	}
	
	public List<ProductsToRent> viewProducts() throws SQLException {
		
		List<ProductsToRent> productList = new ArrayList<>();
		
		String query = "SELECT * FROM ITEMFORRENT";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalshopdb", "root", "placeholder");
		PreparedStatement pst = con.prepareStatement(query);
		
		//used to fetch all the data from the table
		ResultSet rs = pst.executeQuery();
		
		//we then iterate it to put it in a list
		while(rs.next()) {
			Integer pId = rs.getInt("pId");
			String pName = rs.getString("pName");
			String pDescription = rs.getString("pDescription");
			
			ProductsToRent product = new ProductsToRent(pId, pName, pDescription);
			productList.add(product);
		}
		con.close();
		
		for (ProductsToRent product : productList) {
		    System.out.println("Product ID: " + product.getpId());
		    System.out.println("Product Name: " + product.getpName());
		    System.out.println("Product Description: " + product.getpDescription());
		    System.out.println("---------------------------");
		}
		
		return productList;		
	}
	
	public List<Rentals> viewRentalsById(int customerId) throws SQLException {
		
		List<Rentals> rentalsList = new ArrayList<>();
		
		String query = "SELECT * FROM RENTALS WHERE customerId = " + customerId;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalshopdb", "root", "placeholder");
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rs = pst.executeQuery(query);
		
		while(rs.next()) {
			Integer rId = rs.getInt("rentalId");
			Integer cId = rs.getInt("customerId");
			Integer pId = rs.getInt("productId");
			
			// Get the current date as a string
            String rentalDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Calculate the return date as 30 days after the rental date
            LocalDate parsedRentalDate = LocalDate.parse(rentalDate);
            LocalDate returnDate = parsedRentalDate.plusDays(30);

            // Format the return date as a string
            String formattedReturnDate = returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Rentals rental = new Rentals();
            rental.setrId(rId);
            rental.setcId(cId);
            rental.setpId(pId);
            rental.setRentalDate(rentalDate);
            rental.setReturnDate(formattedReturnDate);

            rentalsList.add(rental);
		}
		con.close();
		
		for (Rentals rentals : rentalsList) {
			System.out.println("Rental ID : " + rentals.getrId());
			System.out.println("Customer ID : " + rentals.getcId());
			System.out.println("Product ID : " + rentals.getpId());
			System.out.println("Rental Date : " + rentals.getRentalDate());
			System.out.println("Return Date : " + rentals.getReturnDate());
			System.out.println("Rental Status : " + rentals.getRented());
			System.out.println("---------------------");
		}
		
		
		return rentalsList;
	}
	
	public String updateRentalStatus(Integer rentalId, String newRentedStatus)throws SQLException {
		String query = "UPDATE RENTALS SET Rented = '" + newRentedStatus + "' WHERE rentalId = " + rentalId ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalshopdb", "root", "placeholder");
		PreparedStatement pst = con.prepareStatement(query);
		pst.executeUpdate();
		con.close();
		
		System.out.println("Rental Status For " + rentalId + " has been successfully updated");
		
		return "Status Updated";
	}
	
	
}
