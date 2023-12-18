package com.crif.gd.hsbcb.vida.brick.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.crif.cff.brk.hsbcb.routes.vida.controller.VidaAuthTokenController;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaTokenResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(MockitoExtension.class)
public class vidaControllerTestFinal {

	private static final String ENDPOINT_GET_AUTHTOKEN = "/vida/api/v1/authtoken";

	private static final String ENDPOINT_GET_AUTHTOKENEXPIRED = "/vida/api/v1/authtokenexpired";

	private static final String ENDPOINT_GET_ACCESSTOKEN = "/vida/api/v1/accesstoken";

	private static final String ENDPOINT_GET_REFRESHTOKEN = "/vida/api/v1/refreshtoken";

	@Autowired
	private MockMvc mvc;

	@Mock
	private VidaTokenService vidaTokenService;

	@InjectMocks
	private VidaAuthTokenController vidaAuthTokenController;

	@Test
	public void vidaAuthTokenControllerTest() throws Exception {
		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";
		VidaTokenResponseDto vidaTokenResponseDto = new VidaTokenResponseDto();
		vidaTokenResponseDto.setAccessToken(token);
		// Mock the behavior of the TokenService
		when(vidaTokenService.getVidaAuthToken()).thenReturn(vidaTokenResponseDto);

		// Create MockMvc"
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(vidaAuthTokenController).build();

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_GET_AUTHTOKEN)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();

		String respStr = mvcResult.getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		VidaTokenResponseDto resp = objectMapper.readValue(respStr, VidaTokenResponseDto.class);
		assertEquals(token, resp.getAccessToken());

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	public void GetAuthStatusTest() throws Exception {
		
		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";

        // Set an expiration time, e.g., 1 hour from now
        LocalDateTime expirationTime = LocalDateTime.now().plus(1, ChronoUnit.HOURS);

       
        
        VidaTokenResponseDto vidaTokenResponseDto = new VidaTokenResponseDto();
        vidaTokenResponseDto.setAccessToken(token);
        vidaTokenResponseDto.setExpiresIn(""+expirationTime);

        // Mocking the behavior of TokenService.isAccessTokenExpired()
        when(vidaTokenService.isAccessTokenExpired()).thenReturn(true);

        // Creating MockMvc instance
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(vidaAuthTokenController).build();

        // Performing the GET request to /expired
        mockMvc.perform(get(ENDPOINT_GET_AUTHTOKENEXPIRED)
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
		
	}
	
}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
