package com.myprojects.mkItcount.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.mkItcount.Bean.DateBean;
import com.myprojects.mkItcount.Bean.ExpenseBean;
import com.myprojects.mkItcount.Dao.DaoWrapper;


@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private DaoWrapper dao;

	@Override
	public ExpenseBean addExpense(ExpenseBean expenseBean, String username) {
		// TODO Auto-generated method stub
		return dao.addExpense(expenseBean,username);
	}

	@Override
	public List<ExpenseBean> getExpenses(String username) {
		// TODO Auto-generated method stub
		return dao.getExpenses(username);
	}

	@Override
	public Double findSumOfExpenses(String username) {
		// TODO Auto-generated method stub
		return dao.findSumOfExpenses(username);
	}

	@Override
	public String removeExpense(int expenseid, String username) {
		// TODO Auto-generated method stub
		return dao.removeExpense(expenseid,username);
	}

	@Override
	public ExpenseBean updateExpense(ExpenseBean expenseBean, String username) {
		// TODO Auto-generated method stub
		return dao.updateExpense(expenseBean,username);
	}

	@Override
	public Double findSumOfExpensesBetweenDates(DateBean dateBean, String username) {
		// TODO Auto-generated method stub
		return dao.findSumOfExpensesBetweenDates(dateBean,username);
	}

	@Override
	public Double findSumOfExpensesInaMonth(DateBean dateBean, String username) {
		// TODO Auto-generated method stub
		int year=dateBean.getYear();
		int month = dateBean.getMonth();
		return dao.findSumOfExpensesInaMonth(month,year,username);
	}

	@Override
	public List<ExpenseBean> getExpensesInaMonth(DateBean dateBean, String username) {
		// TODO Auto-generated method stub
		int year = dateBean.getYear();
		int month = dateBean.getMonth();
		return dao.getExpensesInaMonth(month, year,username);
	}

	@Override
	public List<ExpenseBean> getExpensesBetweenDates(DateBean dateBean, String username) {
		// TODO Auto-generated method stub
		LocalDate fromDate = dateBean.getFromDate();
		LocalDate toDate = dateBean.getToDate();
		return dao.getExpensesBetweenDates(fromDate,toDate,username);
	}



}
