package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Arrays;
import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.UserManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl.DefaultUserManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.User;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl.DefaultUser;

public class SignUpMenu implements Menu {

	Scanner in = new Scanner(System.in);
	private UserManagementService userManagementService;
	private ApplicationContext context;
	private DefaultUser defaultUser;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		System.out.print("First name ");
		String firstName = in.nextLine();// Use nextLine() to capture entire line with spaces

		System.out.print("Last name ");
		String lastName = in.nextLine();

		System.out.print("password ");
		String password = in.nextLine(); // Don't use echo for passwords

		System.out.print("E-mail ");
		String email = in.nextLine();

		defaultUser = new DefaultUser(firstName, lastName, password, email);

		if(isEmailValid(defaultUser)) {
			context.setLoggedInUser(defaultUser);
		}
		

		System.out.println(userManagementService.registerUser(defaultUser));
		System.out.println(Arrays.toString(userManagementService.getUsers()));

	}

	@Override
	public void printMenuHeader() {
		System.out.println(System.lineSeparator() + "***Sign Up Menu***" + System.lineSeparator());
	}

	private boolean isEmailValid(User user) {
		if (user.getEmail().matches("[A-Za-z_]+\\@gmail\\.com")) {
			if (userManagementService.getUserByEmail(user.getEmail()) == null) {
				return true;
			}
			
		}
		return false;
	}
}
