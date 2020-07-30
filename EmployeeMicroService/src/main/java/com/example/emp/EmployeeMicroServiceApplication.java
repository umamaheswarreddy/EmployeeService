package com.example.emp;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class EmployeeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroServiceApplication.class, args);
	}
	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/emp/**"))
				.build()
				
				.apiInfo(new ApiInfo("Employee API Documentation",
						"A Sample API for employees",
						"1.0.0",
						"employee is root",
						new Contact("Mahesh", "www.mahesh.com", "maheshuma666S@gmail.com"), 
						"Standard API License",
						"www.mahesh.com",
						Collections.emptyList()));
}
	

}
