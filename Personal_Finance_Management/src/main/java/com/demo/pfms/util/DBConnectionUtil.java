package com.demo.pfms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/projectdb";
    private static final String USER = "root";
    private static final String PASSWORD = "rules";
    
    static {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
