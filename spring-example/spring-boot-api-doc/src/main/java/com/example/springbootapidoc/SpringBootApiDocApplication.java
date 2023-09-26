package com.example.springbootapidoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // Enable Swagger
public class SpringBootApiDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiDocApplication.class, args);
	}

}
