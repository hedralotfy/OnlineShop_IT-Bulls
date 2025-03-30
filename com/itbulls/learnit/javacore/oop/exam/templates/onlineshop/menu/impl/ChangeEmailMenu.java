package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;

public class ChangeEmailMenu implements Menu {

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
			System.out.print("Enter the new Email: ");
			String newEmail = in.nextLine();
			while (true) {
				if (newEmail.matches("[A-Za-z_]+\\@gmail\\.com")) {
					context.getLoggedInUser().setEmail(newEmail);
					System.out.println("\nEmail changed successfully!\n");
					break;
				} else {
					System.out.print("Enter a valid Email: ");
					newEmail = in.nextLine();
				}
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("\n***** Change Email Menu *****\n");
	}

}
