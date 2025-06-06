package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}
