package com.myprojects.mkItcount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.mkItcount.Bean.DateBean;
import com.myprojects.mkItcount.Bean.ExpenseBean;
import com.myprojects.mkItcount.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@PostMapping("/addExpense")
	public ResponseEntity<ExpenseBean> addExpense(@RequestBody ExpenseBean expenseBean) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<ExpenseBean>(expenseService.addExpense(expenseBean, username),HttpStatus.CREATED);
	}
	
	@GetMapping("/getExpnses")
	public ResponseEntity<List<ExpenseBean>> getExpenses(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<List<ExpenseBean>>(expenseService.getExpenses(username),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeExpense")
	public ResponseEntity<String> removeExpense(@RequestBody int expenseid) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<String>(expenseService.removeExpense(expenseid,username),HttpStatus.OK);
		
	}
	
	@PutMapping("/updateExpense")
	public ResponseEntity<ExpenseBean> updateExpense(@RequestBody ExpenseBean expenseBean){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<ExpenseBean>(expenseService.updateExpense(expenseBean, username),HttpStatus.OK);
		
	}
	
	@GetMapping("/getExpnsesInaMonth")
	public ResponseEntity<List<ExpenseBean>> getExpensesInaMonth(@RequestBody DateBean dateBean){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<List<ExpenseBean>>(expenseService.getExpensesInaMonth(dateBean,username),HttpStatus.OK);
	}
	
	@GetMapping("/getExpnsesBetweenDates")
	public ResponseEntity<List<ExpenseBean>> getExpensesBetweenDatesd(@RequestBody DateBean dateBean){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<List<ExpenseBean>>(expenseService.getExpensesBetweenDates(dateBean,username),HttpStatus.OK);
	}
	
	@GetMapping("/sumOfExpenses")
	public ResponseEntity<String> findSumOfExpenses(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<String>("Total amount spent by "+username+" "+"is Rs. "+expenseService.findSumOfExpenses(username),HttpStatus.OK);
	}
	
	@GetMapping("sumOfExpensesBetweenDates")
	public ResponseEntity<String> findSumOfExpensesBetweenDates(@RequestBody DateBean dateBean){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<String>("sum between dates:"+expenseService.findSumOfExpensesBetweenDates(dateBean,username),HttpStatus.OK);		
	}
	
	@GetMapping("sumOfExpensesInaMonth")
	public ResponseEntity<Double> findSumOfExpensesInaMonth(@RequestBody DateBean dateBean){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return new ResponseEntity<Double>(expenseService.findSumOfExpensesInaMonth(dateBean,username),HttpStatus.OK);
	}
	
	
	
	

}
