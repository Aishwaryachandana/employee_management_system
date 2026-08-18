package com.spring.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.employee_management_system.entity.Employee;
import com.spring.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public String createData(Employee employee)
	{
		employeeRepository.save(employee);
		return "Data inserted";
	}
	
	
	public Object fetchByemail(String email)
	{
		Optional<Employee> oe= employeeRepository.findByEmail(email);
		if(oe.isPresent())
		{
			return oe.get();
		}
		else
		{
			return "No data found with email" +email;
		}
	}
	
	
	public List<Employee> fetchAll()
	{
		return employeeRepository.findAll(); 
	}
	
	
	public String deleteByemail(String email)
	{
		Optional<Employee> oe=employeeRepository.findByEmail(email);
		if(oe.isPresent())
		{
			employeeRepository.deleteById(email);
			return "data deleted";
		}else
			return "no data found";
	}
	
	
	
	public String updateByemail(String email,Employee employee)
	{
		Optional<Employee> oe = employeeRepository.findByEmail(email);
		if(oe.isPresent())
		{
			Employee e = oe.get();
			e.setEmail(employee.getEmail());
			e.setName(employee.getName());
			e.setSalary(employee.getSalary());
			e.setDepartment(employee.getDepartment());
			employeeRepository.save(e);
			return "data updated";
			}
		else
		{
			return "no data found";
		}
	}
	
}
