package com.demo.pfms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.demo.pfms.model.Expense;
import com.demo.pfms.util.DBConnectionUtil;

public class ExpenseDAOImpl implements ExpenseDAO {

	private static final String INSERT_EXPENSE = "INSERT INTO expense (user_id, amount, category, description, expense_date) values (?,?,?,?,?)";
	private static final String SELECT_EXPENSE = "SELECT * FROM expense where user_id = ?";
	@Override
	public boolean addExpense(Expense expense) {
		try(
				Connection conn = DBConnectionUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_EXPENSE);
				) {
			ps.setInt(1, expense.getUserId());
			ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setString(4, expense.getDescription());
            ps.setDate(5, java.sql.Date.valueOf(expense.getExpenseDate()));
            
            return ps.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Expense> getExpenseByUser(int userId) {
		
		List<Expense> expenseList = new ArrayList<>();
		
		try(
				Connection conn = DBConnectionUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_EXPENSE);
				) {
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getDate("expense_date").toLocalDate()
                );
                expenseList.add(expense);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return expenseList;
	}
}
