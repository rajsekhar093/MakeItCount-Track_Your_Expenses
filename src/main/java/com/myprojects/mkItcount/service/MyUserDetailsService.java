package com.myprojects.mkItcount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myprojects.mkItcount.Dao.UserDao;
import com.myprojects.mkItcount.Entity.UserEntity;
import com.myprojects.mkItcount.Entity.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity user = userDao.findByUsername(username);
		
		if(user==null) {
			//System.out.println("User not found");
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrincipal(user);
	}

}
