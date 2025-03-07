package com.myprojects.mkItcount.Dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myprojects.mkItcount.Entity.ExpenseEntity;
import com.myprojects.mkItcount.Entity.UserEntity;

public interface ExpenseDao extends JpaRepository<ExpenseEntity, Integer>{

	List<ExpenseEntity> findAllByUser(UserEntity userEntity);

	@Query("SELECT COALESCE(SUM(e.amount), 0) FROM ExpenseEntity e where e.user= :userEntity")
	double findSumOfExpenses(UserEntity userEntity);

	ExpenseEntity findByExpenseid(int expenseid);

	@Query("SELECT COALESCE(SUM(e.amount), 0) FROM ExpenseEntity e where e.user= :userEntity AND(e.date BETWEEN :fromDate AND :toDate)")
	Double findSumOfExpensesBetweenDates(LocalDate fromDate, LocalDate toDate, UserEntity userEntity);

    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM ExpenseEntity e WHERE e.user = :userEntity AND YEAR(e.date) = :year AND MONTH(e.date) = :month")
	Double findSumOfExpensesInaMonth(int month, int year, UserEntity userEntity);

    @Query("SELECT e FROM ExpenseEntity e where e.user= :userEntity AND YEAR(e.date)= :year AND MONTH(e.date)= :month")
	List<ExpenseEntity> findExpensesInaMonth(int month, int year, UserEntity userEntity);	
    
	@Query("SELECT e FROM ExpenseEntity e where e.user= :userEntity AND(e.date BETWEEN :fromDate AND :toDate)")
	List<ExpenseEntity> findExpensesBetweenDates(LocalDate fromDate, LocalDate toDate, UserEntity userEntity);
	
}
