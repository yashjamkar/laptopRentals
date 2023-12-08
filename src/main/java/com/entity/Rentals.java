package com.entity;


public class Rentals {
	private Integer rId;
	private Integer cId;
	private Integer pId;
	private String rentalDate;
	private String returnDate;
	private String rented;
	
	public Rentals() {
		super();
	}

	public Rentals(Integer rId, Integer cId, Integer pId, String rentalDate, String returnDate, String rented) {
		super();
		this.rId = rId;
		this.cId = cId;
		this.pId = pId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.rented = rented;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getRented() {
		return rented;
	}

	public void setRented(String rented) {
		this.rented = rented;
	}
	
}
