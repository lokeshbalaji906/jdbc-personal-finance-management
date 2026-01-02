package com.demo.pfms.dao;

import com.demo.pfms.model.User;

public interface UserDAO {
	
	boolean registerUser(User user);
	
	User login(String email, String password);
}
