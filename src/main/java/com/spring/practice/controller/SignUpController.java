package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.practice.entity.User;
import com.spring.practice.repository.UserRepository;
import com.spring.practice.service.UserService;

@Controller
public class SignUpController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String showRegistrationForm() {
		
		return "signup-form";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.signup(user);
		return "login-form";
	}

}
