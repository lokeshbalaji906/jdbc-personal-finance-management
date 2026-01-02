package com.demo.pfms.dao;

import java.util.*;

import com.demo.pfms.model.Income;

public interface IncomeDAO {
	
	boolean addIncome(Income income);
	
	List<Income> getIncomeByUser(int userId);
}
