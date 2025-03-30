package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.menu.Menu;

public class SettingsMenu implements Menu {

	
	Scanner scan  = new Scanner(System.in);
	ChangePasswordMenu chPw = new ChangePasswordMenu();
	ChangeEmailMenu chEmu = new ChangeEmailMenu();
	
	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email" + System.lineSeparator() + "3. Exit";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		String choice = scan.nextLine();
		while(true) {
			if(choice.equals("1")) {
				chPw.start();
			}
			else if(choice.equals("2")){
				chEmu.start();
			}
			else if(choice.equals("3")) {
				context.getMainMenu();

			}
			else if(!choice.matches("[1-3]")) {
				System.out.println("Please enter a correct choice.");
				choice = scan.nextLine();
				continue;
			}
			break;
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println(SETTINGS);
		System.out.print("User's input ");
	}

}
