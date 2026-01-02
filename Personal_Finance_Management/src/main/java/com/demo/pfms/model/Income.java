package com.demo.pfms.model;

import java.time.LocalDate;

public class Income {
	
	private int incomeId;
	private int userId;
	private double amount;
	private String source;
	private LocalDate incomeDate;
	
	public Income(int userId, double amount, String source, LocalDate incomeDate) {
		this.userId = userId;
		this.amount = amount;
		this.source = source;
		this.incomeDate = incomeDate;
	}

	public int getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public LocalDate getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(LocalDate incomeDate) {
		this.incomeDate = incomeDate;
	}

	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", userId=" + userId + ", amount=" + amount + ", source=" + source
				+ ", incomeDate=" + incomeDate + "]";
	}	
}
