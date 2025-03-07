package com.myprojects.mkItcount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myprojects.mkItcount.Bean.UserBean;
import com.myprojects.mkItcount.Dao.DaoWrapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private DaoWrapper daoWrapper;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public UserBean registerUser(UserBean userBean) {
		// TODO Auto-generated method stub
		userBean.setPassword(encoder.encode(userBean.getPassword()));
		return daoWrapper.registerUser(userBean);
	}

	@Override
	public String verify(UserBean userBean) {
		// TODO Auto-generated method stub
	    Authentication authentication = 
	    		authManager.authenticate(new UsernamePasswordAuthenticationToken(userBean.getUsername(), userBean.getPassword()));
	    if(authentication.isAuthenticated())
	    	return jwtService.generateToken(userBean.getUsername());
		return "Login failed";
	}
	
	

}
