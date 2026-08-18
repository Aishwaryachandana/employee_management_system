package com.spring.employee_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@Email(message = "enter valid email")
	@NotBlank(message = "email cannot be null,empty,space")
	private String email;
	@NotBlank(message = "name cannot be null,empty,space")
	private String name;
	@Positive(message = "salary should >=0")
	private double salary;
	@NotBlank(message = "department cannot be null,empty,space")
	private String department;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
