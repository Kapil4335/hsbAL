package com.crif.cff.brk.hsbcb.routes.otp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ComponentScan(basePackages = "com.crif.cff.brk.hsbcb.routes.otp")
							 
public class OtpBrickApplication extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OtpBrickApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OtpBrickApplication.class, args);
			
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
