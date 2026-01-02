package com.demo.pfms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.pfms.model.Income;
import com.demo.pfms.util.DBConnectionUtil;

public class IncomeDAOImpl implements IncomeDAO {

	private static final String INSERT_INCOME = "INSERT INTO income (user_id, amount, source, income_date) VALUES (?,?,?,?)";
	private static final String SELECT_INCOME = "SELECT * FROM income WHERE user_id = ?";
	@Override
	public boolean addIncome(Income income) {
		try(
				Connection conn = DBConnectionUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_INCOME);
				) {
			
			ps.setInt(1, income.getUserId());
			ps.setDouble(2, income.getAmount());
			ps.setString(3, income.getSource());
			ps.setDate(4, java.sql.Date.valueOf(income.getIncomeDate()));
			
			return ps.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
		return false;
	}

	@Override
	public List<Income> getIncomeByUser(int userId) {
		
		List<Income> incomeList = new ArrayList<>();
		
		try(
				Connection conn = DBConnectionUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_INCOME);
				) {
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Income income = new Income(rs.getInt("user_id"), rs.getDouble("amount"), rs.getString("source"), rs.getDate("income_date").toLocalDate());
				
				incomeList.add(income);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return incomeList;
	}
	
}
