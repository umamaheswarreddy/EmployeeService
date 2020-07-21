package com.example.emp.repository;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.emp.entity.Employee;

@SpringBootTest
@RunWith(SpringRunner.class)

public class EmployeeRepositoryTest {

	@MockBean
	private EmployeeRepository repository;

	@Test
	public void testRepository() {
		Employee emp = new Employee(1, "mahesh", "cde", 24000, "mahesh@gmail.com", 25);
		repository.save(emp);
		Assert.assertNotNull(emp.getId());
	}

	@Test
	public void findByTest() {
		Employee emp = new Employee(1, "mahesh", "cde", 24000, "mahesh@gmail.com", 25);
		when(repository.findById(1)).thenReturn(Optional.of(emp));
	}

}
