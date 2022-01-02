package com.spring.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.entity.Worker;
import com.spring.practice.repository.WorkerRepository;

@Service
public class WorkerService {
	
	
	@Autowired
	private WorkerRepository workerRepository;
	
	public void saveWorkerInfo(Worker worker) {
		
		workerRepository.save(worker);
		
		
	}
	
	public List<Worker> getAllWorkerInfo() {
		
		return workerRepository.findAll();
		//returns worker list
	}
	
	
	//get single worker data
	public Worker getWorkerById(Long id) {
		
		return workerRepository.getById(id);
	}
	
	//delete worker from database
	public void deleteWorker(Long id) {
		
		workerRepository.deleteById(id);
	}

}
