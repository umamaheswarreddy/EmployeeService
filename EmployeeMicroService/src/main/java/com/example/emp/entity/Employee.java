package com.example.emp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
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

	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "name can only have alphabets")
	@Size(min = 3, message = "name must have atleast 3 characters")
	private String name;

	@Size(min = 2, message = "name must have atleast 2 characters")
	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "department can only have alphabets")
	private String department;

	@NotNull(message = "salary should not empty")
	private double salary;
//	
//	@Past(message = "date is should not be future")
//	@JsonFormat(pattern="yyyy-MM-dd")
//	private Date hireDate;

	@Email
	private String email;

	@Range(min = 20, max = 65, message = "empployee age should be between 20 to 65")
	private int age;

	public Employee() {
	}

	public Employee(int id,
			@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "name can only have alphabets") @Size(min = 3, message = "name must have atleast 3 characters") String name,
			@Size(min = 2, message = "name must have atleast 2 characters") @Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "department can only have alphabets") String department,
			@NotNull(message = "salary should not empty") double salary, @Email String email,
			@Range(min = 20, max = 65, message = "empployee age should be between 20 to 65") int age) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.email = email;
		this.age = age;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", email=" + email + ", age=" + age + "]";
	}

}
