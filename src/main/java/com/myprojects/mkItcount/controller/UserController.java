package com.myprojects.mkItcount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.mkItcount.Bean.UserBean;
import com.myprojects.mkItcount.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserBean> register(@RequestBody UserBean userBean) {
		return new ResponseEntity<UserBean>(userService.registerUser(userBean),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserBean userBean) {
		return new ResponseEntity<String>(userService.verify(userBean),HttpStatus.ACCEPTED);
	}

}
