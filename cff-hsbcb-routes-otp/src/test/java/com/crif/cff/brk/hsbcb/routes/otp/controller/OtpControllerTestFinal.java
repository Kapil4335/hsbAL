package com.crif.cff.brk.hsbcb.routes.otp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crif.cff.brk.hsbcb.routes.otp.config.OtpValidationResult;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpRequest;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpResponse;
import com.crif.cff.brk.hsbcb.routes.otp.service.OtpService;
import com.fasterxml.jackson.databind.ObjectMapper;
//@RunWith(MockitoJUnitRunner.class)
public class OtpControllerTestFinal {

	private static final String ENDPOINT_GET_Otp = "/public/api/routes/otp/send/mobile";

	private static final String ENDPOINT_Validate_GET_Otp = "/public/api/routes/otp/validate";
	@Mock
	private MockMvc mockmvc;

	@Mock
	private OtpService otpService;

	@InjectMocks
	private OtpController otpController;

	@BeforeEach
	public void setup() {
//		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.openMocks(this);
		otpService = Mockito.mock(OtpService.class);
		otpController = Mockito.mock(OtpController.class);
		mockmvc = MockMvcBuilders.standaloneSetup(otpController).build();
		l
	}

	@Test
	public void SendOtpTest() throws Exception {
		

//		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(otpController).build();
//
//	MvcResult result = mockmvc.perform(MockMvcRequestBuilders.post(ENDPOINT_GET_Otp)
//	        .contentType(MediaType.APPLICATION_JSON)
//	        .content(asJsonString(result)))
//	        .andExpect(status().isOk())
//		        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		        .andReturn();


//		 MvcResult result = mockmvc.perform(MockMvcRequestBuilders.post(ENDPOINT_GET_Otp)
//		            .contentType(MediaType.APPLICATION_JSON)
//		            .content(asJsonString(createRequest())))
//		            .andExpect(status().isOk())
//		            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		            .andReturn();
		when(otpService.sendOtp(createRequest())).thenReturn(createResponse());
		MvcResult result = mockmvc.perform(
				post(ENDPOINT_GET_Otp).contentType(MediaType.APPLICATION_JSON).content(asJsonString(createRequest())))
				.andExpect(status().isOk()).andReturn();
		String responseBody = result.getResponse().getContentAsString();
		
		System.out.println("Hii" + responseBody);
//		OtpResponse actualOtpResponse = new ObjectMapper().readValue(responseBody, OtpResponse.class);

		// Assert on the actualOtpResponse properties
//		assertEquals("123456", actualOtpResponse.getOtp());

		// verify(otpService, times(1)).sendOtp(eq(request));

	}

	private OtpRequest createRequest() {
		String name = "kapil";
		String ektp = "ygdyb";
		String email = "kapil44@gmail.com";
		String countryCode = "536365";
		String phoneNumber = "84676356477";
		String giftID = "23344jjfdj334";
		OtpRequest request = new OtpRequest();
		request.setName(name);
		request.setEktp(ektp);
		request.setEmail(email);
		request.setCountryCode(countryCode);
		request.setPhoneNumber(phoneNumber);
		request.setGiftID(giftID);
		return request;
	}

	private OtpResponse createResponse() {
		String mobileNumber = "84676356477";
		String ektpNumber = "ygdyb";
		String otp = "123456";
		Instant blockedUntil = Instant.parse("2023-12-08T12:00:00Z");
		OtpValidationResult otpValidationResult = null;
		OtpResponse mockedOtpResponse = new OtpResponse();
		mockedOtpResponse.setEktpNumber(ektpNumber);
		mockedOtpResponse.setOtp(otp);
		mockedOtpResponse.setMobileNumber(mobileNumber);
		mockedOtpResponse.setBlockedUntil(blockedUntil);
		mockedOtpResponse.setOtpValidationResult(otpValidationResult);
		return mockedOtpResponse;
	}

	private static String asJsonString(Object obj) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);

	}

//	@Test
	public void ValidateOtpTest() throws Exception {

		OtpController otpController = new OtpController();
		// Arrange
		OtpRequest otpRequest = new OtpRequest(/* your test data */);
		String receivedOtp = "123456"; // set your test OTP

		// Mock the behavior of otpService.validateOtp()
		OtpResponse expectedResponse = new OtpResponse(/* your expected response data */);
		when(otpService.validateOtp(any(OtpRequest.class), any(String.class))).thenReturn(expectedResponse);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(otpController).build();

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(ENDPOINT_Validate_GET_Otp).contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(otpRequest)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		// Act
		ResponseEntity<OtpResponse> responseEntity = otpController.validateOtp(otpRequest, receivedOtp);

		// Assert
		assertEquals(expectedResponse, responseEntity.getBody());
		// Add more assertions as needed
	}

}
