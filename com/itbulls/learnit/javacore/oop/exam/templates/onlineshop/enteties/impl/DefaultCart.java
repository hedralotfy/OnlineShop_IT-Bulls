package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Cart;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Product;

public class DefaultCart implements Cart {

	private static Product[] addedProducts = new Product[10];
	private static int counter = 0;
	
	@Override
	public boolean isEmpty() {
	    int emptyCounter = 0;
	    for (Product product : addedProducts) {
	        if (product == null) {
	            emptyCounter++;
	        }
	    }
	    return emptyCounter == (addedProducts.length); 
	}

	@Override
	public void addProduct(Product product) {
		if(addedProducts[addedProducts.length-1]!=null) {
			Product[] temp = new Product[addedProducts.length];
			
			System.arraycopy(addedProducts, 0, temp, 0, addedProducts.length);
			addedProducts = new Product[addedProducts.length+10];
			System.arraycopy(temp, 0, addedProducts, 0, temp.length);
		}
		addedProducts[counter++] = product;
	}

	@Override
	public Product[] getProducts() {
		return addedProducts;
	}

	@Override
	public void clear() {
		addedProducts = new Product[10];
		counter = 0;
	}

}
