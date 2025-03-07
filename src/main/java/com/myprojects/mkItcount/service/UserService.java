package com.myprojects.mkItcount.service;

import com.myprojects.mkItcount.Bean.UserBean;

public interface UserService {
	UserBean registerUser(UserBean userBean);

	String verify(UserBean userBean);
}
