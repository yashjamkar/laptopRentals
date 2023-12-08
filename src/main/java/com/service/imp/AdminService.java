package com.service.imp;

import java.sql.SQLException;
import java.util.List;

import com.dao.AdminDAO;
import com.entity.ProductsToRent;
import com.entity.Rentals;
import com.service.AdminServiceRepo;

public class AdminService implements AdminServiceRepo {

	AdminDAO ad = new AdminDAO();

	public String addProduct(Integer pId, String pName, String pDescription) throws SQLException {
		String msg = null;
		if (pId != 0 && pName != null && pDescription != null) {
			msg = ad.addProduct(pId, pName, pDescription);
		} else {
			System.out.println("Please Enter Valid Details");
		}
		return msg;
	}

	public String addCustomer(Integer cId, String cName, String cPass) throws SQLException {
		String msg = null;
		if(cId != 0 && cName != null && cPass != null) {
			msg = ad.addCustomer(cId, cName, cPass);
		} else {
			System.out.println("Please Enter Valid Details");
		}
		return msg;
	}

	public List<ProductsToRent> viewProducts() throws SQLException {
		return ad.viewProducts();
	}

	public List<Rentals> viewRentalsById(Integer customerId) throws SQLException {
		List<Rentals> msg = null;
		if(customerId != 0) {
			msg = ad.viewRentalsById(customerId);
		}else {
			System.out.println("Please Enter A Valid Input");
		}
		return msg;
	}

	public String updateRentalStatus(Integer rentalId, String newRentedStatus) throws SQLException {
		String msg = null;
		if(rentalId != 0) {
			msg = ad.updateRentalStatus(rentalId, newRentedStatus);
		} else {
			System.out.println("Please Enter A Valid Input");
		}
		return msg;
	}
	
}
