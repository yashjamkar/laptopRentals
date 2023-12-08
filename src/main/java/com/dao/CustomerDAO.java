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

import com.entity.Rentals;

public class CustomerDAO {

	public String rentAProduct(Integer cId, Integer pId) throws SQLException {

		LocalDate rentalDate = LocalDate.now();

		LocalDate returnDate = rentalDate.plusDays(30);

		int rId = Integer.parseInt(String.valueOf(cId) + String.valueOf(pId));

		String query = "INSERT INTO RENTALS (rentalId, customerId, productId, rentalDate, returnDate) VALUES (" + rId + "," + cId + ","
				+ pId + "," + rentalDate + "," + returnDate + ")";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentalshopdb", "root", "placeholder");
		PreparedStatement pst = con.prepareStatement(query);
		pst.execute();
		con.close();

		return "Selected Product For Rent";
	}

	public List<Rentals> viewRentalStatus(Integer customerId) throws SQLException {
		
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

		while (rs.next()) {
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
}
