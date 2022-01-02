package com.spring.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.entity.User;
import com.spring.practice.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void signup(User user) {
		
		userRepository.save(user);
	}
	
	public User login(String eml, String psw) {
		
		return userRepository.findByEmailAndPassword(eml, psw);
	}

}
