package com.crif.gd.hsbcb.vida.brick.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.crif.cff.brk.hsbcb.routes.vida.controller.VidaAuthTokenController;

//@SpringBootTest
class VidaAuthTokenControllerTest {

	@Autowired
	VidaAuthTokenController vidaController;
	
	private MockMvc mockMvc;

	 @Autowired
	 private WebApplicationContext webApplicationContext;

	//@BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
//	@Test
	//@DisplayName("Test the GET /vida/authtoken endpoint")
	void testGetVidaAuthToken() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/vida/authtoken"))
        .andExpect(MockMvcResultMatchers.status().isOk());
       // .andExpect(MockMvcResultMatchers.content().string("User list goes here"));
	}
}
