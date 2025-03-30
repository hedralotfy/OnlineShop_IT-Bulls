package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.ProductManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		
		Scanner in = new Scanner(System.in);

		while (true) {
			printMenuHeader();
			System.out.println("\nEnter product id to add it to the cart or"
					+ " 'menu' if you want to navigate back to the main menu");
			String choice = in.nextLine();
			
			if (choice.matches("([Mm]enu)")) {
				break;
			} else if (choice.matches("(" + CHECKOUT_COMMAND + ")")) {
				if (context.getLoggedInUser() != null) {
					if (context.getSessionCart().isEmpty()) {
						System.out.println("Your cart is empty. Please, add product to cart"
								+ " first and then proceed with checkout");
					} else {
						CheckoutMenu ckm = new CheckoutMenu();
						ckm.start();
					}
				}else {
					System.out.println("You are not logged in. Please, sign in or create new account");
					break;
				}
			} else if (Integer.valueOf(choice) instanceof Integer) {
				if (productManagementService.getProductById(Integer.valueOf(choice)) != null) {
					context.getSessionCart()
							.addProduct(productManagementService.getProductById(Integer.valueOf(choice)));
					System.out.println("Product "
							+ productManagementService.getProductById(Integer.valueOf(choice)).getProductName()
							+ " is added to the checkout.\n");
				} else {
					System.out.println("Please, enter product ID if you want to add product to cart."
							+ " Or enter ‘checkout’ if you want to proceed with checkout."
							+ " Or enter ‘menu’ if you want to navigate back to the main menu.");
				}
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\nProducts Catalog\n");

		for (int i = 0; i < productManagementService.getProducts().length; i++) {
			System.out.println(productManagementService.getProducts()[i].toString());
		}

	}
}
