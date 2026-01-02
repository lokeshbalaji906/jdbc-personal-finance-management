package com.demo.pfms.main;

import com.demo.pfms.dao.UserDAO;
import com.demo.pfms.dao.UserDAOImpl;
import com.demo.pfms.model.User;

public class PFMSApp {
	public static void main(String[] args) {
		
		UserDAO userDAO = new UserDAOImpl();
		
		// Register user
		User user = new User("Balu", "b@gmail.com", "1234");
		boolean registered = userDAO.registerUser(user);
		System.out.println("User Registered: "+registered);
		
		// Login user
		User loggedInUser = userDAO.login("b@gmail.com", "1234");
		if(loggedInUser != null) {
			System.out.println("Login Successfull: "+loggedInUser.getName());
		} else {
			System.out.println("Invalid Credentials");
		}
	}
}