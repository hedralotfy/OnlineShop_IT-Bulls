package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private static int orderCounter;
	private static Order[] orders = new Order[DEFAULT_ORDER_CAPACITY];

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		orders[orderCounter++] = order;
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		
		int userOrders = 0;
		for(int i = 0; i<getOrders().length; i++) {
			if(getOrders()[i]!=null && getOrders()[i].getCustomerId()==userId) {
				userOrders++;
			}
		}
		
		Order[] filteredOrders = new Order[userOrders];
		
		for(int i = 0, j = 0; i<getOrders().length; i++) {
			if(getOrders()[i]!=null && getOrders()[i].getCustomerId()==userId) {
				filteredOrders[j]=getOrders()[j];
				j++;
			}
		}
		
		return filteredOrders;
	}

	@Override
	public Order[] getOrders() {
		if (orders[orders.length - 1] != null) {
			
			int newCapacity = DEFAULT_ORDER_CAPACITY;
			Order[] tempOrders = new Order[newCapacity+10];
			for (int i2 = 0, j = 0; j < orders.length; i2++, j++) {
				tempOrders[j] = orders[i2];
			}
			orders = new Order[newCapacity];
			for (int k = 0, j = 0; k < tempOrders.length; k++, j++) {
				orders[j] = tempOrders[k];
			}
		}
		if(orderCounter==0) {
			return null;
		}
		
		return orders;
	}

	void clearServiceState() {
		orderCounter = 0;
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

}
