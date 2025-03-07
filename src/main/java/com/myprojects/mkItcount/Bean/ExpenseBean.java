package com.myprojects.mkItcount.Bean;

import java.time.LocalDate;

public class ExpenseBean {
	
	private int expenseid;
	private String expenseName;
	private Double amount;
	private String category;
	private LocalDate date;
	
	//private UserBean user;

	public int getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(int expenseid) {
		this.expenseid = expenseid;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
/*
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
*/
	@Override
	public String toString() {
		return "ExpenseBean [expenseid=" + expenseid + ", expenseName=" + expenseName + ", amount=" + amount
				+ ", category=" + category + ", date=" + date + "]";
	}

	
	
	

}
