package com.ashu.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.entity.Employee;
import com.ashu.excHandle.IdNotFoundException;
import com.ashu.repository.EmployeeRepo;
import com.ashu.services.EmployeeServices;
@Service
public class EmployeeServiceImpl implements EmployeeServices {
	
	@Autowired
	private EmployeeRepo repo;
	
	
	public Integer saveEmployee(Employee emp) {
		
		emp = repo.save(emp);
		
		return emp.getEmpCode();
	}
	
	
	
	public void deleteEmployee(Integer empCode) {
		repo.deleteById(empCode);
		
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		repo.save(emp);
		
	}
	
	
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return repo.findAll();
	}



	@Override
	public Employee getOneEmployee(Integer empCode) {

      Optional<Employee> opt = repo.findById(empCode);
      
      if(opt.isPresent()) 
    	  return opt.get();
      else 
		throw new IdNotFoundException("Employee With id "+empCode+"  Not Found ");
	}
	
	



}
