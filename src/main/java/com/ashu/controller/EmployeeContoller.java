package com.ashu.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashu.entity.Employee;
import com.ashu.services.EmployeeServices;

@Controller
//@RestController

public class EmployeeContoller {

	public static Logger logger = LoggerFactory.getLogger(EmployeeContoller.class);

	


	@Autowired
	private EmployeeServices service;
	
	
//	@GetMapping("/login")
//	public String showLogin() {
//		return "login";
//	}

	@GetMapping("/form")
	public String showReg() {
		logger.info("FROM INFO");
		logger.debug("FROM DEBUG");
		
		logger.warn("FROM WARN");
		logger.error("FROM ERROR");


		return "createForm";      

	}



	@GetMapping("/findall")
	public String getAllEmp(@RequestParam(required = false) String message,Model model){
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("list", list);
		model.addAttribute("message", message);

		return "dataPage";

	}



	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute Employee employee, Model model, BindingResult result) {

		Integer id = service.saveEmployee(employee);
		
		if(result.hasErrors()) {
			System.out.println("ERROR "+result.toString());
			model.addAttribute("EMP", employee);
			return "createForm";
		}

		String message ="Employee with EMPLOYEE CODE :"+id+"  Created";
		model.addAttribute("message",message);
		return "createForm";                     // call data page "redirect:all";  here all is another page
	}
	
	

	//	@DeleteMapping("/delete/{empCode}")
	//	public String deleteEmployee(@PathVariable Integer empCode) {
	//		
	//		service.deleteEmployee(empCode);
	//		return "Employee Deleted Success";
	//		
	//	}


	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer empCode, RedirectAttributes attributes) {

		service.deleteEmployee(empCode);
		attributes.addAttribute("message", "Employee :"+empCode+"  Deleted ");
		return "redirect:findall";

	}


	@GetMapping("/edit")
	public String ShowEdit(@RequestParam Integer empCode, //getting id

			Model model)  // sending Data to UI) 
	{

		Employee e = service.getOneEmployee(empCode);
		model.addAttribute("employee", e);
		return "EmployeeEdit";
	}





	//	@PutMapping("/update")
	//	public String updateEmployee(@RequestBody Employee employee) {
	//		service.updateEmployee(employee);
	//		return "Employee Upadted Success";
	//		
	//	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee, RedirectAttributes attributes) {
		service.updateEmployee(employee);
		attributes.addAttribute("message", "Employee :"+employee.getEmpCode()+"  Updated ");
		return "redirect:findall";

	}


}
