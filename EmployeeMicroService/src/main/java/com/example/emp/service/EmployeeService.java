package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Employee;
import com.example.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public List<Employee> getAllEmps() {
		return repo.findAll();
	}

	public void addemp(Employee emp) {
		 repo.save(emp);
	}

	public void deleteEmp(int id) {
		 repo.deleteById(id);
	}

	public Optional<Employee> getEmpByid(int id) {
		
		return repo.findById(id);
	}
	
}
