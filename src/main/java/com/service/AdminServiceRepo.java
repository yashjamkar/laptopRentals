package com.service;

import java.sql.SQLException;
import java.util.List;

import com.entity.ProductsToRent;
import com.entity.Rentals;

public interface AdminServiceRepo {
	
	public String addProduct(Integer pId, String pName, String pDescription) throws SQLException;
	
	public String addCustomer(Integer cId, String cName, String cPass) throws SQLException;
	
	public List<ProductsToRent> viewProducts() throws SQLException;
	
	public List<Rentals> viewRentalsById(Integer customerId) throws SQLException;
	
	public String updateRentalStatus(Integer rentalId, String newRentedStatus) throws SQLException;
	
}
