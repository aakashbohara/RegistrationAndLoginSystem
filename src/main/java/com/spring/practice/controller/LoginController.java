package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.practice.entity.Employee;
import com.spring.practice.entity.User;
import com.spring.practice.repository.UserRepository;
import com.spring.practice.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String showLoginPage() {
		
		return "login-form";
	}
	
	
//	@GetMapping("/demo")
//	public String showDemoPage() {
//		
//		return "demo";
//	}
//	
	
//	
//	if(user.getName().equals("ram") && user.getPassword().equals("123"))
//	{
//		return "demo";
//	}
	
	
//	@PostMapping("/login")
//	public String login(@ModelAttribute User user, Model model) {
//		
//		User u = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
//		
//		if(u != null) {
//			
//			model.addAttribute("uname", u.getName());
//			return "home";
//		}
//		
//		model.addAttribute("msg", "user not found !!!");
//		return "login-form";
//	}
	
	
	@PostMapping("/login")
	public String eLogIn(@ModelAttribute User user, Model model) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User e = userService.login(user.getEmail(), user.getPassword());
		
		if(e != null) {
			
			model.addAttribute("uname", e.getName());
			
			
			return "home";
			
		}
		model.addAttribute("msg", "user not found !!!");
		return "login-form";
	}

}
