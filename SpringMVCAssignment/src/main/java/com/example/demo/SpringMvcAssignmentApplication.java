package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.springmvc.controller"})
@SpringBootApplication
public class SpringMvcAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcAssignmentApplication.class, args);
	}

}

