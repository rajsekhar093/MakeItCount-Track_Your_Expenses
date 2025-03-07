package com.myprojects.mkItcount.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Expenses")
public class ExpenseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int expenseid;
	private String expenseName;
	private Double amount;
	private String category;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private UserEntity user;

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ExpenseEntity [expenseid=" + expenseid + ", expenseName=" + expenseName + ", amount=" + amount
				+ ", category=" + category + ", date=" + date + ", user=" + user + "]";
	}
	
	
}
