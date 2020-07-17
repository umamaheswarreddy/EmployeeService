package com.example.emp.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
   
	@Size(min = 3, message = "name must have atleast 3 characters")
	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "name can only have alphabets")
	private String name;
	
	@Size(min = 3, message = "name must have atleast 3 characters")
	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "department can only have alphabets")
	private String department;
	
	@NotEmpty(message = "salary should not be empty")
	private double salary;
	
	@Past(message = "date is should not be future")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	
	@Range(min = 20, max = 65,message = "empployee age should be between 20 to 65")
	@NotEmpty(message = "age should not be empty")
	private int age;
	
	public Employee() {}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	
	
	
	
	

}
