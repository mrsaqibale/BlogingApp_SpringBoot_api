package com.blog;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class BlogingAppApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
