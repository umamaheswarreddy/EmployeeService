package com.example.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Employee;
import com.example.emp.exceptions.EmployeeNotFoundException;
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
		
		Employee emp = repo.findById(id).orElse(null);
		if (emp == null) 
		{
			throw new EmployeeNotFoundException("employeeId " + id + " not avilable to delete");
		}
		repo.deleteById(id);
	}

	public Employee getEmpByid(int id) {

		Employee emp = repo.findById(id).orElse(null);
		if (emp == null) {
			throw new EmployeeNotFoundException("employeeId " + id + " not avilable to get");
		}
		return emp;

	}

}
