package com.demo.pfms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.pfms.model.User;
import com.demo.pfms.util.DBConnectionUtil;

public class UserDAOImpl implements UserDAO {

	private static final String INSERT_USER = "INSERT INTO users (name, email, password) VALUES (?,?,?)";
	private static final String LOGIN_USER = "SELECT user_id, name, email FROM users WHERE email = ?";
	
	@Override
	public boolean registerUser(User user) {
		try (Connection conn = DBConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_USER);
				) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			return ps.executeUpdate() > 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User login(String email, String password) {
		try (Connection conn = DBConnectionUtil.getConnection();
	             PreparedStatement ps = conn.prepareStatement(LOGIN_USER)
	            )	{
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
