package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl.DefaultOrder;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.OrderManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {

	private Order userOrder = new DefaultOrder(null, null, 0);
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		System.out.println("\nEnter your credit card number without spaces and press enter if you confirm purchase\n");
		Scanner in = new Scanner(System.in);
		String creditCardNumber = in.nextLine();
		while(true) {
			if(userOrder.isCreditCardNumberValid(creditCardNumber)) {
				userOrder.setProducts(context.getSessionCart().getProducts());
				userOrder.setCreditCardNumber(creditCardNumber);
				userOrder.setCustomerId(context.getLoggedInUser().getId());
				//
				orderManagementService.addOrder(userOrder);
				System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
				context.getSessionCart().clear();
				break;
			}else {
				System.out.print("Please enter a valid credit card number: ");
				creditCardNumber = in.nextLine();
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\nCheckout Menu\n");
	}

}
