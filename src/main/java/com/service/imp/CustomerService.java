package com.service.imp;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDAO;
import com.entity.Rentals;
import com.service.CustomerServiceRepo;

public class CustomerService implements CustomerServiceRepo{
	
	CustomerDAO cd = new CustomerDAO();
	
	public String rentAProduct(Integer cId, Integer pId) throws SQLException {
		String msg = null;
		if(cId != 0 && pId != 0) {
			msg = cd.rentAProduct(cId, pId);
		} else {
			System.out.println("Please Enter Valid Details");
		}
		return msg;
	}

	public List<Rentals> viewRentalStatus(Integer customerId) throws SQLException {
		List<Rentals> msg = null;
		if(customerId != 0) {
			msg = cd.viewRentalStatus(customerId);
		} else {
			System.out.println("Please Enter A Valid Input");
		}
		return msg;
	}
	
}
