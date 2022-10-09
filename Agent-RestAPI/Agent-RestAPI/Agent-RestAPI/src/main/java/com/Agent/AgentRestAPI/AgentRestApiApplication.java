package com.Agent.AgentRestAPI;
/*
 * @naem AgentRestApiApplication
 * @author Alonso Montelongo, Ethan Harness
 * @version 1.0
 * @data 10/08/2022
 * @purpose This class is where Java Spring Boot creates a server to run the 
 * application
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
	 * @name main
	 * @purpose Allows us to run the application
	 * @precondition none
	 * @postcondition Will run our application constantly
	 * @param String[]args : A String argument
	 * @return void : none
	 */
	public static void main(String[] args) {
		SpringApplication.run(AgentRestApiApplication.class, args);
	}
	/*
	 * @name corsConfigurue
	 * @purpose Configures our API endpoints by overiding addCorsMappings
	 * @precondtionn Endpoins must exsit
	 * @postcondition Allows user to call the endpoints via GET request
	 * @param none
	 * @return configurations to Spring Boot
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