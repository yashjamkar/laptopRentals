package com.entity;

public class ProductsToRent {
	private Integer pId;
	private String pName;
	private String pDescription;
	
	public ProductsToRent() {
		super();
	}

	public ProductsToRent(Integer pId, String pName, String pDescription) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDescription = pDescription;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
}
