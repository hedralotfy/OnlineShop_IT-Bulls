package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();

}
