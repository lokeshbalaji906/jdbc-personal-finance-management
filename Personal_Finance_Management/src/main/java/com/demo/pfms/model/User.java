package com.demo.pfms.model;

public class User {				// DTO class
	
	private int userId;
	private String name;
	private String email;
	private String password;
	
	public User() {}			// Zero Argument Constructor

	public User(int userId, String name, String email, String password) {		// Parameterized Constructor
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {			// toString
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}
