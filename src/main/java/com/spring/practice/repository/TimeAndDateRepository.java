package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.practice.entity.TimeAndDate;

@Repository
public interface TimeAndDateRepository extends JpaRepository<TimeAndDate, Long>{
	
	

}
