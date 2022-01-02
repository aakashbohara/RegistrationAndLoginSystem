package com.spring.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.practice.entity.TimeAndDate;
import com.spring.practice.repository.TimeAndDateRepository;

@Service
public class TimeAndDateService {
	
	@Autowired
	private TimeAndDateRepository tdRepo;
	
	public void saveTimeAndDate(TimeAndDate timeAndDate) {
		
		tdRepo.save(timeAndDate);
		
		
	}

}
