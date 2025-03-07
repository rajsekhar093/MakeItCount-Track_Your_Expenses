package com.myprojects.mkItcount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/welcome")
	public String greet(HttpServletRequest request) {
		return "Welcome to make it count "+request.getSession().getId();
	}

}
