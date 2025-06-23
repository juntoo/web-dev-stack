package com.kh.inheritance.model;

import com.kh.inheritance.model.parent.Product;

public class SmartPhone extends Product{
	
	private String agency;

	public SmartPhone() {}

	public SmartPhone(String brand, String pCode, String name, int price, String agency) {
		super(brand, pCode, name, price);
		this.agency = agency;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return super.getBrand() + ", " + this.getpCode() + ", " + super.getName() + ", " + super.getPrice() + ", " + "SmartPhone [agency=" + agency + "]";
	}
}
