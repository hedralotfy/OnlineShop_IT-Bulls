package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.OrderManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if(context.getLoggedInUser()!=null) {
			if(orderManagementService.getOrders()==null) {
				System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order\n");
			}else {
				for(Order order : orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId())) {
					System.out.println(order.toString());
				}
			}
			
		}else {
			System.out.println("Please, log in or create new account to see list of your orders");
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n*****My Orders*****\n");		
	}

}
