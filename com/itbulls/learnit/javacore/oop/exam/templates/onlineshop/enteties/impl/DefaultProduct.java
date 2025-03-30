package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Product;

public class DefaultProduct implements Product {
	
	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public DefaultProduct() {
	}
	
	public DefaultProduct(int id, String productName, String categoryName, double price) {
//		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "DefaultProduct [id=" + getId() + ", productName=" + getProductName() + ", categoryName=" + categoryName
				+ ", price=" + price + "]";
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	
}
