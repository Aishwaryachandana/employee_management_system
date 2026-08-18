package com.spring.employee_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee_management_system.entity.Employee;
import com.spring.employee_management_system.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	@PostMapping
	public String createData (@Valid @RequestBody Employee employee)
	{
	return employeeService.createData(employee);
	}
	
	
	@GetMapping("/{email}")
	public Object fetchByemail(@PathVariable String email)
	{
		return employeeService.fetchByemail(email);
	}
	

	@GetMapping("/all")
	public List<Employee> fetchAll()
	{
		return employeeService.fetchAll();
	}
	
	
	@DeleteMapping("/{email}")
	public String deleteByemail(@PathVariable String email)
	{
		return employeeService.deleteByemail(email);
	}
	
	
	
	@PutMapping("/{email}")
	public String updateByemail(@PathVariable String email, @RequestBody Employee employee)
	{
	return employeeService.updateByemail(email,employee);
	}
	
	
}
