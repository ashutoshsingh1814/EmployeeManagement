package com.ashu.services;

import java.util.List;

import com.ashu.entity.Employee;

public interface EmployeeServices {
	
	Integer saveEmployee(Employee emp);
	void deleteEmployee(Integer empCode);
	void updateEmployee(Employee emp);
	List<Employee> getAllEmployee();
	Employee getOneEmployee(Integer empCode);
}
