package com.service;

import java.sql.SQLException;
import java.util.List;

import com.entity.Rentals;

public interface CustomerServiceRepo {
	
	public String rentAProduct(Integer cId, Integer pId) throws SQLException;
	
	public List<Rentals> viewRentalStatus(Integer customerId) throws SQLException;
}
