package com.demo.pfms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.pfms.model.MonthlySummary;
import com.demo.pfms.util.DBConnectionUtil;

public class ReportDAOImp implements ReportDAO {

    private static final String TOTAL_INCOME_SQL =
        "SELECT IFNULL(SUM(amount),0) FROM income " +
        "WHERE user_id = ? AND MONTH(income_date) = ? AND YEAR(income_date) = ?";

    private static final String TOTAL_EXPENSE_SQL =
        "SELECT IFNULL(SUM(amount),0) FROM expense " +
        "WHERE user_id = ? AND MONTH(expense_date) = ? AND YEAR(expense_date) = ?";

    @Override
    public MonthlySummary getMonthlySummary(int userId, int month, int year) {

        double totalIncome = 0;
        double totalExpense = 0;

        try (Connection conn = DBConnectionUtil.getConnection()) {

            try (PreparedStatement ps1 = conn.prepareStatement(TOTAL_INCOME_SQL)) {
                ps1.setInt(1, userId);
                ps1.setInt(2, month);
                ps1.setInt(3, year);

                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    totalIncome = rs1.getDouble(1);
                }
            }

            try (PreparedStatement ps2 = conn.prepareStatement(TOTAL_EXPENSE_SQL)) {
                ps2.setInt(1, userId);
                ps2.setInt(2, month);
                ps2.setInt(3, year);

                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    totalExpense = rs2.getDouble(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new MonthlySummary(totalIncome, totalExpense);
    }
}