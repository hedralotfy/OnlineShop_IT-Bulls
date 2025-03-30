package com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.impl;


import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.enteties.User;
import com.itbulls.learnit.javacore.oop.exam.templates.onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;
	private static int newCapacity = DEFAULT_USERS_CAPACITY;
	private static User[] REGISTERED_USERS = new User[DEFAULT_USERS_CAPACITY];
	private User regiUser;
	private static User[] tempUsers;
	private static int counter = 0;

	private static DefaultUserManagementService instance;

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		if (user.getEmail().matches("[A-Za-z_]+\\@gmail\\.com")) {
			if (getUserByEmail(user.getEmail())==null) {
				regiUser = user;
				REGISTERED_USERS[counter++] = regiUser;
				getUsers();
				return NO_ERROR_MESSAGE + "User registered successfully!";
			} else {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}
		return EMPTY_EMAIL_ERROR_MESSAGE;

	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public User[] getUsers() {
		return REGISTERED_USERS = manageCapacity(REGISTERED_USERS);
	}


	@Override
	public User getUserByEmail(String userEmail) {
		if (userEmail.matches("[A-Za-z_]+\\@gmail\\.com")) {
			for (int i = 0; i < getUsers().length; i++) {
				if (getUsers()[i]!=null && userEmail.equals(getUsers()[i].getEmail())) {
					return getUsers()[i];
				}
			}
		}
		return null;
	}

	void clearServiceState() {
		REGISTERED_USERS = new User[DEFAULT_USERS_CAPACITY];
		counter = 0;
	}

	private static User[] manageCapacity(User[] userArray) {
		if (userArray[userArray.length - 1] != null) {
			newCapacity += 10;
			tempUsers = new User[newCapacity];
			for (int i2 = 0, j = 0; j < userArray.length; i2++, j++) {
				tempUsers[j] = userArray[i2];
			}
			userArray = new User[newCapacity];
			for (int k = 0, j = 0; k < tempUsers.length; k++, j++) {
				userArray[j] = tempUsers[k];
			}

		}

		return userArray;
	}

}
