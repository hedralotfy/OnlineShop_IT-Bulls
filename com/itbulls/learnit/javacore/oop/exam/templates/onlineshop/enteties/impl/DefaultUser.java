package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.impl;

import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.User;

public class DefaultUser implements User {


	String firstName;
	String lastName;
	String password;
	String email;
	private static int id = 0;

	public DefaultUser(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		DefaultUser.id++;
	}

	@Override
	public String getFirstName() {
		// <write your code here>
		return this.firstName;
	}

	@Override
	public String getLastName() {
		// <write your code here>
		return this.lastName;
	}

	@Override
	public String getPassword() {
		// <write your code here>
		return this.password;
	}

	@Override
	public String getEmail() {
		// <write your code here>
		return this.email;
	}
	
	/*
	 * 28-2-2025:
	 * 
	 * We will remove the password field from the toString() method.
	 */
	@Override
	public String toString() {
		return "DefaultUser [firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return DefaultUser.id;
	}
	
	void clearState() {
		DefaultUser.id = 0;
	}
}
