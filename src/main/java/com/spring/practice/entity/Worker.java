package com.spring.practice.entity;


import java.time.LocalDateTime;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Worker {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workerId;
	
	private String workerName;
	
	private String workergender;
	
	private String workerPhone;
	
	private String workerEmail;
	
//	@DateTimeFormat(iso = ISO.DATE)   //(pattern = "MM-DD-YYYY")  //(iso = ISO.DATE) //or (pattern = "yyyy-MM-dd")
	private Date workerDob;
	
//	@DateTimeFormat(iso = ISO.DATE)
	private Date workerJoinDate;
	
	private int workerSalary;
	
	private String company;
	
	@OneToOne(cascade = CascadeType.ALL) //if deleted worker then address will be deleted to0
	@JoinColumn(name = "addressId")
	private Address workerAddress;
	
	
	@CreationTimestamp  //automatic goes time of creation
	private LocalDateTime workerCreated;
	
	
	@UpdateTimestamp //automatic goes time of update
	private LocalDateTime workerUpdated;
	
	

	public Date getWorkerDob() {
		return workerDob;
	}

	public void setWorkerDob(Date workerDob) {
		this.workerDob = workerDob;
	}

	public Date getWorkerJoinDate() {
		return workerJoinDate;
	}

	public void setWorkerJoinDate(Date workerJoinDate) {
		this.workerJoinDate = workerJoinDate;
	}

	public String getWorkerPhone() {
		return workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}

	public Long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkergender() {
		return workergender;
	}

	public void setWorkergender(String workergender) {
		this.workergender = workergender;
	}

	public String getWorkerEmail() {
		return workerEmail;
	}

	public void setWorkerEmail(String workerEmail) {
		this.workerEmail = workerEmail;
	}




	public int getWorkerSalary() {
		return workerSalary;
	}

	public void setWorkerSalary(int workerSalary) {
		this.workerSalary = workerSalary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Address getWorkerAddress() {
		return workerAddress;
	}

	public void setWorkerAddress(Address workerAddress) {
		this.workerAddress = workerAddress;
	}

	public LocalDateTime getWorkerCreated() {
		return workerCreated;
	}

	public void setWorkerCreated(LocalDateTime workerCreated) {
		this.workerCreated = workerCreated;
	}

	public LocalDateTime getWorkerUpdated() {
		return workerUpdated;
	}

	public void setWorkerUpdated(LocalDateTime workerUpdated) {
		this.workerUpdated = workerUpdated;
	}
	
	
}
