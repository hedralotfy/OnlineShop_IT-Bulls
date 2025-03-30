package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;

public class ChangePasswordMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		if (context.getLoggedInUser() == null) {
			System.out.println("\nPlease login or sign up then try again.\n");
		} else {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the new Password: ");
			String newPass = in.nextLine();
			while (true) {
				context.getLoggedInUser().setPassword(newPass);
				System.out.println("\nPassword changed successfully!\n");
				break;
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** Change Password Menu *****\n");
	}

}
