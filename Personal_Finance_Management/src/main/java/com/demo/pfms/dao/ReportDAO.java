package com.demo.pfms.dao;
import com.demo.pfms.model.MonthlySummary;

public interface ReportDAO {
	
	MonthlySummary getMonthlySummary(int userId, int month, int year);
	
}