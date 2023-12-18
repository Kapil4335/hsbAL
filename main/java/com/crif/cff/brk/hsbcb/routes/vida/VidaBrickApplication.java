package com.crif.cff.brk.hsbcb.routes.vida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VidaBrickApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VidaBrickApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(VidaBrickApplication.class, args);
	}

}
