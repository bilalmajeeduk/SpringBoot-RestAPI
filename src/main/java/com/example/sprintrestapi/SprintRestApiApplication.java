package com.example.sprintrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SprintRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintRestApiApplication.class, args);
		System.out.println("this is the sample GET APP");
	}

}
