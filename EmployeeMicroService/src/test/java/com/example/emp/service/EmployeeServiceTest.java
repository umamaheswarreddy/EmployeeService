package com.example.emp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.emp.entity.Employee;
import com.example.emp.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository repo;

	@InjectMocks
	private EmployeeService service;

	@Test
	public void testAddEmp() {
		Employee emp = new Employee(1, "mahesh", "cde", 24000, "mahesh@gmail.com", 25);
		service.addemp(emp);
		verify(repo, times(1)).save(emp);

	}

	@Test
	public void testGetEmployeeById() {
		Employee emp = new Employee(1, "mahesh", "hr", 1000, "chandhu@gmail.com", 22);
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(emp));
		assertEquals("chandhu@gmail.com", service.getEmpByid(emp.getId()).getEmail());
	}

	@Test
	public void testGetEmpById() {
		when(repo.findById(1)).thenReturn(Optional.of(new Employee(1, "mahesh", "hr", 1000, "chandhu@gmail.com", 22)));
		Employee emp = service.getEmpByid(1);
		assertEquals("mahesh", emp.getName());
		assertEquals(22, emp.getAge());

	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> list = new ArrayList<>();
		Employee emp1 = new Employee(1, "mahesh", "hr", 1000, "chanu@gmail.com", 22);
		Employee emp2 = new Employee(2, "mathesh", "cde", 2000, "math@gmail.com", 23);
		list.add(emp1);
		list.add(emp2);
		when(repo.findAll()).thenReturn(list);
		List<Employee> empList = service.getAllEmps();
		assertEquals(2, empList.size());
	}

	@Test
	public void testDeleteEmplotee() {
		Employee emp = new Employee(1, "mahesh", "hr", 1000, "chanu@gmail.com", 22);
		when(repo.findById(1)).thenReturn(Optional.of(emp));

		Mockito.when(repo.existsById(emp.getId())).thenReturn(false);
		assertFalse(repo.existsById(emp.getId()));

	}

}