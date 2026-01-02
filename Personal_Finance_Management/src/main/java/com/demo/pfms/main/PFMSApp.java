package com.demo.pfms.main;

import java.time.LocalDate;

import com.demo.pfms.dao.ExpenseDAO;
import com.demo.pfms.dao.ExpenseDAOImpl;
import com.demo.pfms.dao.IncomeDAO;
import com.demo.pfms.dao.IncomeDAOImpl;
import com.demo.pfms.dao.ReportDAO;
import com.demo.pfms.dao.ReportDAOImp;
import com.demo.pfms.dao.UserDAO;
import com.demo.pfms.dao.UserDAOImpl;
import com.demo.pfms.model.Expense;
import com.demo.pfms.model.Income;
import com.demo.pfms.model.MonthlySummary;
import com.demo.pfms.model.User;

public class PFMSApp {
	public static void main(String[] args) {
		
//		UserDAO userDAO = new UserDAOImpl();
//		
//		// Register user
//		User user = new User("Balu", "b@gmail.com", "1234");
//		boolean registered = userDAO.registerUser(user);
//		System.out.println("User Registered: "+registered);
//		
//		// Login user
//		User loggedInUser = userDAO.login("b@gmail.com", "1234");
//		if(loggedInUser != null) {
//			System.out.println("Login Successfully: "+loggedInUser.getName());
//		} else {
//			System.out.println("Invalid Credentials");
//		}
		
//		IncomeDAO incomeDAO = new IncomeDAOImpl();
//		ExpenseDAO expenseDAO = new ExpenseDAOImpl();
//		
//		incomeDAO.addIncome(new Income(1, 50000, "Salary", LocalDate.now()));
//		incomeDAO.addIncome(new Income(1, 60000, "Salary", LocalDate.now()));
//		expenseDAO.addExpense(new Expense(1, 1500, "Food", "Lunch", LocalDate.now()));
//		expenseDAO.addExpense(new Expense(1, 2500, "Food", "Lunch", LocalDate.now()));
//		
//		System.out.println("Income and Expense added successfully");
		
		ReportDAO reportDAO = new ReportDAOImp();
		MonthlySummary summary = reportDAO.getMonthlySummary(1, 1, 2026);
		
		System.out.println(summary.getTotalExpense());
		System.out.println(summary.getTotalIncome());
	}
}