package com.demo.pfms.model;

import java.time.LocalDate;

public class Expense {

    private int expenseId;
    private int userId;
    private double amount;
    private String category;
    private String description;
    private LocalDate expenseDate;
	
    public Expense(int userId, double amount, String category, String description, LocalDate expenseDate) {
		this.userId = userId;
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.expenseDate = expenseDate;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", userId=" + userId + ", amount=" + amount + ", category="
				+ category + ", description=" + description + ", expenseDate=" + expenseDate + "]";
	}
}
