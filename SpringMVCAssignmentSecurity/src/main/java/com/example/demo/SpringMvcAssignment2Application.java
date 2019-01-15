package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.springassign.controller","com.springassign.service","com.springassign.aspect"})
@EntityScan("com.springassign.model")
@EnableJpaRepositories("com.springassign.repo")
public class SpringMvcAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcAssignment2Application.class, args);
	}

}

