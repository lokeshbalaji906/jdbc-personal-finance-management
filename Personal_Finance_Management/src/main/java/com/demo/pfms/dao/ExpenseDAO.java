package com.demo.pfms.dao;

import java.util.*;

import com.demo.pfms.model.Expense;

public interface ExpenseDAO {
	
	boolean addExpense(Expense expense);
	
	List<Expense> getExpenseByUser(int userId);
	
}
