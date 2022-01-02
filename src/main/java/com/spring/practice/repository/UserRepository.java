package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.practice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmailAndPassword(String eml, String psw);



}
