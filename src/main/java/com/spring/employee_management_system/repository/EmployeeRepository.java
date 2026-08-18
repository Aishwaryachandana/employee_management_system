package com.spring.employee_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.employee_management_system.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	Optional<Employee> findByEmail(String email);


}
