package com.demo.pfms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.demo.pfms.model.Expense;
import com.demo.pfms.model.Income;
import com.demo.pfms.util.DBConnectionUtil;

public class FinanceService {

    private static final String INSERT_INCOME =
        "INSERT INTO income (user_id, amount, source, income_date) VALUES (?, ?, ?, ?)";

    private static final String INSERT_EXPENSE =
        "INSERT INTO expense (user_id, amount, category, description, expense_date) VALUES (?, ?, ?, ?, ?)";

    public void addIncomeAndExpense(Income income, Expense expense) {

        Connection conn = null;

        try {
            conn = DBConnectionUtil.getConnection();
            conn.setAutoCommit(false); // BEGIN TRANSACTION

            try (PreparedStatement ps1 = conn.prepareStatement(INSERT_INCOME);
                 PreparedStatement ps2 = conn.prepareStatement(INSERT_EXPENSE)) {

                ps1.setInt(1, income.getUserId());
                ps1.setDouble(2, income.getAmount());
                ps1.setString(3, income.getSource());
                ps1.setDate(4, java.sql.Date.valueOf(income.getIncomeDate()));
                ps1.executeUpdate();

                ps2.setInt(1, expense.getUserId());
                ps2.setDouble(2, expense.getAmount());
                ps2.setString(3, expense.getCategory());
                ps2.setString(4, expense.getDescription());
                ps2.setDate(5, java.sql.Date.valueOf(expense.getExpenseDate()));
                ps2.executeUpdate();

                conn.commit(); // COMMIT
            }

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback(); // ROLLBACK
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
