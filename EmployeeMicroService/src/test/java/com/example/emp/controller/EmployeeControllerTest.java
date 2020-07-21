package com.example.emp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpoyeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService service;

	@Test
	public void getAllTest() throws Exception {
		when(service.getAllEmps())
				.thenReturn(Arrays.asList(new Employee(1, "mahesh", "hr", 24000.0, "mahesh@gmail.com", 25)));

		RequestBuilder request = MockMvcRequestBuilders.get("/emp/all").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content()
						.json("[{id:1, name:mahesh, department:hr, salary:24000.0, email:mahesh@gmail.com, age:25}]"))
				.andReturn();
	}

	@Test
	public void getEmpByIdTest() throws Exception {
		when(service.getEmpByid(1)).thenReturn(new Employee(1, "mahesh", "hr", 24000, "mahesh@gmail.com", 25));

		RequestBuilder request = MockMvcRequestBuilders.get("/emp/{id}", 1).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content()
						.json("{id:1, name:mahesh, department:hr, salary:24000.0, email:mahesh@gmail.com, age:25}"))
				.andReturn();
	}

	@Test
	public void addEmpTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/emp/add").accept(MediaType.APPLICATION_JSON).content(
			"{    \"id\":1, "
				+ "\"name\": \"koushik\", "
				+ "\"department\": \"CDEa\", "
				+ "\"salary\": \"24000\", "
				+ "\"emailId\":\"koushik@gmail.com\","
				+ "\"age\":\"25\"}")
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}
	@Test
	public void updateEmpTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.put("/emp/update").accept(MediaType.APPLICATION_JSON).content(
			"{    \"id\":1, "
				+ "\"name\": \"koushik\", "
				+ "\"department\": \"CDEa\", "
				+ "\"salary\": \"24000\", "
				+ "\"emailId\":\"koushik@gmail.com\","
				+ "\"age\":\"25\"}")
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}

	@Test
	public void deleteEmpById() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.delete("/emp/delete/{id}",1).accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}
	
	
	
}
