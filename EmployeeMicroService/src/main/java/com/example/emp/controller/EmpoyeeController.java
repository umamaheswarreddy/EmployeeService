package com.example.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmpoyeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return service.getAllEmps();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return service.getEmpByid(id);

	}

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee emp) {

		service.addemp(emp);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/update")
	public void updateEmployee(@Valid @RequestBody Employee emp) {

		service.addemp(emp);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable int id) {

		service.deleteEmp(id);
	}

	@GetMapping("/test")
	public String test() {
		return "testing works";
	}

}
