package com.myprojects.mkItcount.Dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myprojects.mkItcount.Bean.DateBean;
import com.myprojects.mkItcount.Bean.ExpenseBean;
import com.myprojects.mkItcount.Bean.UserBean;
import com.myprojects.mkItcount.Entity.ExpenseEntity;
import com.myprojects.mkItcount.Entity.UserEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DaoWrapper {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ExpenseDao expenseDao;
	
	public UserBean registerUser(UserBean userBean) {
		UserEntity userEntity = convertUserBeanToEntity(userBean);
		UserEntity userEntitySaved = userDao.save(userEntity);
		return convertUserEntityToBean(userEntitySaved);
	}
	
	
	private ExpenseBean convertExpenseEntityToBean(ExpenseEntity entity) {
		// TODO Auto-generated method stub
		ExpenseBean bean=new ExpenseBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

	private ExpenseEntity convertExpenseBeanToEntity(ExpenseBean expenseBean) {
		// TODO Auto-generated method stub
		ExpenseEntity entity = new ExpenseEntity();
		BeanUtils.copyProperties(expenseBean, entity);
		return entity;
	}
	

	private UserBean convertUserEntityToBean(UserEntity userEntitySaved) {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		BeanUtils.copyProperties(userEntitySaved, bean);
		return bean;
	}

	private UserEntity convertUserBeanToEntity(UserBean userBean) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userBean, entity);
		return entity;
	}


	public ExpenseBean addExpense(ExpenseBean expenseBean, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		ExpenseEntity expenseEntity = convertExpenseBeanToEntity(expenseBean);
		expenseEntity.setUser(userEntity);
		
		ExpenseEntity savedExpenseEntity = expenseDao.save(expenseEntity);
		//UserBean savedUserBean =convertUserEntityToBean(savedExpenseEntity.getUser());
		ExpenseBean expenseBeanSaved=convertExpenseEntityToBean(savedExpenseEntity);
		//expenseBeanSaved.setUser(savedUserBean);
		return expenseBeanSaved;
	}


	public List<ExpenseBean> getExpenses(String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		List<ExpenseEntity> expenseEntityList = expenseDao.findAllByUser(userEntity);
		
		List<ExpenseBean> expenseBeanList = new ArrayList<>();
		
		for(ExpenseEntity entity : expenseEntityList) {
			expenseBeanList.add(convertExpenseEntityToBean(entity));
		}
		return expenseBeanList;
	}


	public String removeExpense(int expenseid, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		ExpenseEntity expenseEntity = expenseDao.findByExpenseid(expenseid);
		if(expenseEntity==null)
			return "No such expense found";
		expenseDao.delete(expenseEntity);
		return "Expense Removed";
	}


	public ExpenseBean updateExpense(ExpenseBean expenseBean, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		ExpenseEntity expenseEntity = expenseDao.findByExpenseid(expenseBean.getExpenseid());
		if(expenseEntity==null)
			throw new RuntimeException("No such expense");
		if(expenseBean.getExpenseName()!=null){
			expenseEntity.setExpenseName(expenseBean.getExpenseName());
		}
		if(expenseBean.getAmount()!=null) {
			expenseEntity.setAmount(expenseBean.getAmount());
		}
		if(expenseBean.getCategory()!=null)
		{
			expenseEntity.setCategory(expenseBean.getCategory());
		}
		if(expenseBean.getDate()!=null)
		{
			expenseEntity.setDate(expenseBean.getDate());
		}
		ExpenseEntity expenseEntitySaved = expenseDao.save(expenseEntity);
		
		return convertExpenseEntityToBean(expenseEntitySaved);
	}

	public Double findSumOfExpenses(String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		Double amount;
		amount = expenseDao.findSumOfExpenses(userEntity);
		return amount;
	}
	
	public Double findSumOfExpensesBetweenDates(DateBean dateBean, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		Double amount;
		amount = expenseDao.findSumOfExpensesBetweenDates(dateBean.getFromDate(),dateBean.getToDate(),userEntity);
		return amount;
	}


	public Double findSumOfExpensesInaMonth(int month, int year, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		Double amount;
		amount = expenseDao.findSumOfExpensesInaMonth(month,year,userEntity);
		return amount;
	}


	public List<ExpenseBean> getExpensesInaMonth(int month, int year, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		List<ExpenseEntity> expenseEntityList = expenseDao.findExpensesInaMonth(month,year,userEntity);
		List<ExpenseBean> expenseBeanList = new ArrayList<>();
		for(ExpenseEntity entity:expenseEntityList) {
			expenseBeanList.add(convertExpenseEntityToBean(entity));
		}
		return expenseBeanList;
	}


	public List<ExpenseBean> getExpensesBetweenDates(LocalDate fromDate, LocalDate toDate, String username) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByUsername(username);
		if(userEntity==null) {
			throw new RuntimeException("User not found");
		}
		List<ExpenseEntity> expenseEntityList = expenseDao.findExpensesBetweenDates(fromDate,toDate,userEntity);
		List<ExpenseBean> expenseBeanList = new ArrayList<>();
		for(ExpenseEntity entity:expenseEntityList) {
			expenseBeanList.add(convertExpenseEntityToBean(entity));
		}
		return expenseBeanList;
	}
	
	

}
