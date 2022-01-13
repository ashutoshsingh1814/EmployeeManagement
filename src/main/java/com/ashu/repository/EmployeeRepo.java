package com.ashu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	

}
