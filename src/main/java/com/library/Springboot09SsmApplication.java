package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Springboot09SsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot09SsmApplication.class, args);
	}

}
