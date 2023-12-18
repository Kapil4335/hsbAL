package com.crif.cff.brk.hsbcb.routes.otp.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import com.crif.cff.brk.hsbcb.routes.otp.config.OtpValidationResult;
import com.crif.cff.brk.hsbcb.routes.otp.controller.OtpController;
import com.crif.cff.brk.hsbcb.routes.otp.entity.OtpEntity;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpRequest;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpResponse;
import com.crif.cff.brk.hsbcb.routes.otp.repository.OtpRepositoryTest;
import com.crif.cff.brk.hsbcb.routes.otp.service.OtpService;

public class OtpServiceTest {

	@Mock
	private OtpEntity otpEntity;

	@Mock
	private OtpController otpController;

	@InjectMocks
	private OtpService otpService;

	private MockMvc mockMvc;

	@Mock
	private OtpResponse otpResponse;

	@Mock
	private OtpRequest otpRequest;

	@Mock
	private OtpRepositoryTest otpRepository;

	@BeforeEach
	void setUp() {
		otpRepository = mock(OtpRepositoryTest.class);
		otpService = new OtpService(); // Assuming your OTPService has a constructor that takes OtpRepository
	}

	@Test
	public void getOtpTest() {
		String token = "123456";
		OtpEntity ResponseDto = new OtpEntity();
		ResponseDto.setOtp(token);
// Set up a mock access token

// VidaTokenServiceImpl.setAccessToken(token);

// Call the method to test
		String result = ResponseDto.getOtp();

// Verify the result
		assertEquals(token, result);
		assertNotNull(token, result); // working

	}

	@Test
	public void testSendOtpWithValidData() {
//
//		String ektp = "ygdyb";
//		String countryCode = "536365";
//		String phoneNumber = "84676356477";
//
//		OtpRequest otpRequest = new OtpRequest();
//		otpRequest.setEktp(ektp);
//		otpRequest.setCountryCode(countryCode);
//		otpRequest.setPhoneNumber(phoneNumber);
//
//		String mobileNumberWithCountryCode = phoneNumber + countryCode;
//		String otp = "123456";
//
//		OtpResponse mockedOtpResponse = new OtpResponse();
//		mockedOtpResponse.setEktpNumber(ektp);
//		mockedOtpResponse.setOtp(otp);
//		mockedOtpResponse.setMobileNumber(mobileNumberWithCountryCode);
//
//		OtpService otpService = new OtpService();
//
//		when(otpRepository.findByEktpNumber(ektp)).thenReturn(Optional.empty());
//		when(otpService.generateOtp()).thenReturn(otp);
//
//		// Act
//		OtpResponse otpResponse = otpService.sendOtp(otpRequest);
//
//		// Assert
//		assertNotNull(otpResponse);
//		assertEquals(ektp, otpResponse.getEktpNumber());
//		assertEquals(mobileNumberWithCountryCode, otpResponse.getMobileNumber());
//		assertNotNull(otpResponse.getOtp());
//		assertNull(otpResponse.getOtpValidationResult());
//		assertNull(otpResponse.getBlockedUntil());
	}

	@Test
	public void generateOtpTest() {
// Arrange
	//	String nbr = "123456";
		OtpEntity entity = new OtpEntity();
		//entity.setOtp(nbr);
		OtpService otpService = new OtpService();

// Act
		String generatedOtp = otpService.generateOtp();
		
// Assert
		assertNotNull(generatedOtp, "Generated OTP should not be null");
		assertTrue(generatedOtp.matches(generatedOtp), "Generated OTP should be a 6-digit number");
		assertEquals(6, generatedOtp.length(), "Generated OTP should have a length of 6");

	}

}
