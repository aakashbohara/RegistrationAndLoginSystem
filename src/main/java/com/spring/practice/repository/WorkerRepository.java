package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.practice.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
