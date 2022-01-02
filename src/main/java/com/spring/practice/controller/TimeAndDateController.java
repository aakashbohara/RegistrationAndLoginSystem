package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.spring.practice.entity.TimeAndDate;
import com.spring.practice.service.TimeAndDateService;

@Controller
public class TimeAndDateController {
	
	
	@Autowired
	private TimeAndDateService timeAndDateService;
	
	@GetMapping("/tdpage")
	public String showTDPage(Model model) {
		
		model.addAttribute("tdObject", new TimeAndDate());
		
		return "tDPage";
	}
	
	
	@PostMapping("/tdpage")
	public String saveTD(@ModelAttribute TimeAndDate timeAndDate) 
	
	{
		timeAndDateService.saveTimeAndDate(timeAndDate);
		return "redirect:/tdpage";
	}

}
