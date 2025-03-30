package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl;

import java.util.Arrays;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	
	public DefaultOrder(String creditCardNumber, Product[] products, int customerId) {
		this.creditCardNumber = creditCardNumber;
		this.products = products;
		this.customerId = customerId;
	}

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		return creditCardNumber.length() == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER && !creditCardNumber.matches("[A-Za-z]+");
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	@Override
	public void setProducts(Product[] products) {

		this.products = products;
	}
	
	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return "DefaultOrder [creditCardNumber= " + creditCardNumber + ", customerId=" + customerId + 
				 ", \nproducts= " + Arrays.toString(products) + "]";
	}

}
