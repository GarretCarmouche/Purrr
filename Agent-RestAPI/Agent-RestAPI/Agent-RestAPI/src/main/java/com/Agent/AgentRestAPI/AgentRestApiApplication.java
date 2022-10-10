package com.Agent.AgentRestAPI;
/*
 * File Name: AgentRestApiApplication.java
 * Author: Alonso Montelongo, Kole Soto, Garret Carmouche
 * Version: 1.0
 * Data: 10/08/2022
 * Purpose: This class is where Java Spring Boot creates a server to run the 
 * application
 * CS 3368 Introduction to Artificial Intelligence Section 001
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

//The @SpringBootApplication annotation tags the class as a source for bean definition, allows our application to add the beans by our class paths, and tells spring boot to configure the application
@SpringBootApplication
public class AgentRestApiApplication implements WebMvcConfigurer {
	/*
	 * Name: main
	 * Purpose: Allows us to run the application
	 * Precondition: none
	 * Postcondition: Will run our application constantly
	 * Param: String[]args : A String argument
	 * Return: void : none
	 */
	public static void main(String[] args) {
		SpringApplication.run(AgentRestApiApplication.class, args);
	}
	/*
	 * Name: corsConfigurue
	 * Purpose: Configures our API endpoints by overiding addCorsMappings
	 * Precondtion: Endpoins must exsit
	 * Postcondition: Allows user to call the endpoints via GET request
	 * Param: none
	 * Return: configurations to Spring Boot
	 * 
	 */
	
	//The Bean annotation allows Spring Boot container to manage our API endpoints
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/aicontroller/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}