package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.practice.entity.Employee;
import com.spring.practice.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/elogin")
	public String showEmployeeLoginPage() {
		
		return "eLogin";
	}
	
	@GetMapping("/eregister")
	public String showEmployeeRegisterPage() {
		
		return "eRegister";
	}
	
	//model for other terms in the database
	@PostMapping("/elogin")
	public String eLogIn(@ModelAttribute Employee employee, Model model) {
		employee.setPassword(DigestUtils.md5DigestAsHex(employee.getPassword().getBytes()));
		Employee e = employeeRepository.findByUsernameAndPassword(employee.getUsername(), employee.getPassword());
		
		if(e != null) {
			
			model.addAttribute("uname", e.getName());
			
			
			return "home";
			
		}
		model.addAttribute("msg", "user not found !!!");
		return "eLogin";
	}
	
	@RequestMapping(value = "/eregister", method = RequestMethod.POST )
	public String eRegister(@ModelAttribute Employee employee) {
		employee.setPassword(DigestUtils.md5DigestAsHex(employee.getPassword().getBytes()));
		employeeRepository.save(employee);
		
		return "eLogin";
	}

}
