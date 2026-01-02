package com.demo.pfms.model;

public class MonthlySummary {
	
	private double totalIncome;
	private double totalExpense;
	
	public MonthlySummary(double totalIncome, double totalExpense) {
		super();
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
	}

	public double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}

	@Override
	public String toString() {
		return "MonthlySummary [totalIncome=" + totalIncome + ", totalExpense=" + totalExpense + "]";
	}
}
