package com.entity;

public class Customer {
	private Integer cId;
	private String cName;
	private String cPass;
	
	public Customer() {
		super();
	}

	public Customer(Integer cId, String cName, String cPass) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPass = cPass;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPass() {
		return cPass;
	}

	public void setcPass(String cPass) {
		this.cPass = cPass;
	}
	
	
}
