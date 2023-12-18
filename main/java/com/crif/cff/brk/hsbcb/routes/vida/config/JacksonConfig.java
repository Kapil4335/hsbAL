package com.crif.cff.brk.hsbcb.routes.vida.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //jackson datatype module for JDK8 java.time
        //register the module to access Instant class
        //JavaTimeModule is required for Instant class
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
