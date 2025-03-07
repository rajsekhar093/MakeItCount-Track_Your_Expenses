package com.myprojects.mkItcount.service;

import java.util.List;

import com.myprojects.mkItcount.Bean.DateBean;
import com.myprojects.mkItcount.Bean.ExpenseBean;

public interface ExpenseService {

	ExpenseBean addExpense(ExpenseBean expenseBean, String username);

	List<ExpenseBean> getExpenses(String username);

	Double findSumOfExpenses(String username);

	String removeExpense(int expenseid, String username);

	ExpenseBean updateExpense(ExpenseBean expenseBean, String username);

	Double findSumOfExpensesBetweenDates(DateBean dateBean, String username);

	Double findSumOfExpensesInaMonth(DateBean dateBean, String username);

	List<ExpenseBean> getExpensesInaMonth(DateBean dateBean, String username);

	List<ExpenseBean> getExpensesBetweenDates(DateBean dateBean, String username);
	

}
