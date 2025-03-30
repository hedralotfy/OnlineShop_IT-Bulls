package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.UserManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	Scanner in = new Scanner(System.in);

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		System.out.print("E-mail: ");
		String email = in.nextLine();

		System.out.print("password: ");
		String password = in.nextLine();

		if (userManagementService.getUserByEmail(email) != null
				&& userManagementService.getUserByEmail(email).getPassword().equals(password)) {
			System.out.printf("Glad to see you back %s %s", userManagementService.getUserByEmail(email).getFirstName(),
					userManagementService.getUserByEmail(email).getLastName());
			context.setLoggedInUser(userManagementService.getUserByEmail(email));
		} else {
			System.out.println("Unfortunately, such login and password doesn’t exist");
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n*****Sign In Menu*****\n");
	}
}
