package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.UserManagementService;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl.DefaultUserManagementService;

public class MainMenu implements Menu {
	Scanner in = new Scanner(System.in);
	SignUpMenu signUp = new SignUpMenu();
	SignInMenu signIn = new SignInMenu();
	SignOutMenu signOut = new SignOutMenu();
	ProductCatalogMenu productCatalog = new ProductCatalogMenu();
	MyOrdersMenu myOrders = new MyOrdersMenu();
	SettingsMenu settings = new SettingsMenu();
	CustomerListMenu customerList = new CustomerListMenu();
	private UserManagementService userManagementService;

	public static final String MENU_COMMAND = "menu";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign In" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign Out" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings";

	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {

		while (true) {
			printMenuHeader();
			System.out.print("User input: ");
			String choice = in.next();
			if (choice.equals("1")) {
				signUp.start();
				System.out.println();
			}
			else if (choice.equals("2")) {
				signIn.start();
				System.out.println();
			}
			else if (choice.equals("3")) {
				productCatalog.start();
				System.out.println();
			}
			else if (choice.equals("4")) {
				myOrders.start();
				System.out.println();
			}
			else if (choice.equals("5")) {
				settings.start();
				System.out.println();
			}
			else if(choice.equals("6")) {
				customerList.start();
			}

			else if (!choice.matches("^[1-5]")) {
				System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
				choice = in.next();
			}
			
			if(context.getLoggedInUser()!=null) {
				loggedInMenuChoices();
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println(MENU_COMMAND + System.lineSeparator());

		System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);

	}

	private void loggedInMenuChoices() {
		System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
		System.out.print("User input: ");
		String choice = in.next();
		if (choice.equals("1")) {
			signUp.start();
			System.out.println();
		}
		else if (choice.equals("2")) {
			context.setMainMenu(new MainMenu());
			signOut.start();
			System.out.println();
		}
		else if (choice.equals("3")) {
			productCatalog.start();
			System.out.println();
		}
		else if (choice.equals("4")) {
			myOrders.start();
			System.out.println();
		}
		else if (choice.equals("5")) {
			settings.start();
			System.out.println();
		}
		/*
		 * 28-2-2025:
		 * I added this case to the loggedInMenuChoice(), but it's not included in the
		 * menu. 
		 */
		else if(choice.equals("6")) {
			customerList.start();
		}
		else if (!choice.matches("^[1-5]")) {
			System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
			choice = in.next();
		}
		if(context.getLoggedInUser()!=null) {
			loggedInMenuChoices();
		}
	}

}
