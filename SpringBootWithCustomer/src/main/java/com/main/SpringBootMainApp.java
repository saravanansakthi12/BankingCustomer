package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.main")
public class SpringBootMainApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApp.class, args);
	}
}