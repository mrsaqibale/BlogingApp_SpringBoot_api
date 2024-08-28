package com.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.blog.exceptions.GlobalExceptionHandler;

@SpringBootApplication
public class BlogingAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogingAppApiApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
