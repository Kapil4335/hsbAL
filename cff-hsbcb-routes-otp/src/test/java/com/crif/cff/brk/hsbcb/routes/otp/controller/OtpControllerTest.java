package com.crif.cff.brk.hsbcb.routes.otp.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.time.Instant;
import com.crif.cff.brk.hsbcb.routes.otp.config.OtpValidationResult;
import com.crif.cff.brk.hsbcb.routes.otp.entity.OtpEntity;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpRequest;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpResponse;
import com.crif.cff.brk.hsbcb.routes.otp.repository.OtpRepositoryTest;
import com.crif.cff.brk.hsbcb.routes.otp.service.OtpService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

//@WebMvcTest(OtpController.class) // Replace YourController with the actual name of your controller class
//@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class OtpControllerTest {

	private static final String ENDPOINT_GET_Otp = "/public/api/routes/otp/send/mobile";
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private OtpResponse otpResponse;

	@Mock
	private OtpRequest otpRequest;

	@Mock
	private OtpEntity OtpEntity;

	@InjectMocks
	private OtpController otpControllerTest;


	@Mock
	private OtpService otpService; // Replace YourService with the actual name of your service class
	  @Before
	    public void setup() {
		  mockMvc = MockMvcBuilders.standaloneSetup(otpControllerTest).build();
	    	    }
	@Test
	public void SendOtpTest() throws Exception {
		String name = "kapil";
		String ektp = "ygdyb";
		String email = "kapil44@gmail.com";
		String countryCode = "536365";
		String phoneNumber = "84676356477";
		String cardType = "credit card";
		String giftID = "23344jjfdj334";
		OtpRequest request = new OtpRequest(/* provide necessary data */);

		request.setName(name);
		request.setEktp(ektp);
		request.setEmail(email);
		request.setCountryCode(countryCode);
		request.setPhoneNumber(phoneNumber);
		request.setGiftID(giftID);

		/////////////////////////////////////////////////////////////////
		String mobileNumber = "84676356477";
		String ektpNumber = "ygdyb";
		String otp = "123456";
		Instant blockedUntil = Instant.parse("2023-12-08T12:00:00Z");

		int numberOfOtpLeft = 4;
		OtpValidationResult otpValidationResult = null;

		OtpResponse mockedOtpResponse = new OtpResponse();

		mockedOtpResponse.setEktpNumber(ektpNumber);
		mockedOtpResponse.setOtp(otp);
		mockedOtpResponse.setMobileNumber(mobileNumber);
		mockedOtpResponse.setBlockedUntil(blockedUntil);
		mockedOtpResponse.setOtpValidationResult(otpValidationResult);

	
		// when(otpController.sendOtp(any(OtpRequest.class))).thenReturn(mockedOtpResponse);

		when(otpService.sendOtp(any(OtpRequest.class))).thenReturn(mockedOtpResponse);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(ENDPOINT_GET_Otp).contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		// Extract OtpResponse from the response
		String responseBody = result.getResponse().getContentAsString();

		OtpResponse actualOtpResponse = new ObjectMapper().readValue(responseBody, OtpResponse.class);

		// Assert on the actualOtpResponse properties
		assertEquals("123456", actualOtpResponse.getOtp());

		verify(otpService, times(1)).sendOtp(eq(request));

	}

	private static String asJsonString(Object obj) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);

	}
}
