package com.crif.cff.brk.hsbcb.routes.otp.servicetest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.crif.cff.brk.hsbcb.routes.otp.config.OtpValidationResult;
import com.crif.cff.brk.hsbcb.routes.otp.controller.OtpController;
import com.crif.cff.brk.hsbcb.routes.otp.entity.OtpEntity;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpRequest;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpResponse;
import com.crif.cff.brk.hsbcb.routes.otp.repository.OtpRepositoryTest;
import com.crif.cff.brk.hsbcb.routes.otp.service.OtpService;

//@RunWith(PowerMockRunner.class)
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(OtpService.class)
public class OtpServiceFinal {

	@Mock
	private OtpEntity otpEntity;

	@Mock
	private OtpRepositoryTest otpRepository;

	@InjectMocks
	private OtpService otpService;

	@Mock
	private OtpController otpController;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	public void generateOtpTest() {
// Arrange
		// String nbr = "123456";
		OtpEntity entity = new OtpEntity();
		// entity.setOtp(nbr);
		OtpService otpService = new OtpService();

// Act
		String generatedOtp = otpService.generateOtp();

// Assert
		assertNotNull(generatedOtp, "Generated OTP should not be null");
		// assertEquals(6, generatedOtp.length(), "Generated OTP should have a length of
		// 6");

	}

	@Test
	public void testIsOtpCanRegen_OtpCanBeRegenerated()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		// Arrange
		OtpEntity otpEntity = new OtpEntity();
		otpEntity.setOtpGeneratedAt(Instant.now().minusSeconds(10)); // Otp generated 10 seconds ago

		Method isOtpCanRegen = OtpService.class.getDeclaredMethod("isOtpCanRegen", OtpEntity.class);
		isOtpCanRegen.setAccessible(true);

		// Invoke the private method
		boolean result = (boolean) isOtpCanRegen.invoke(otpService, otpEntity);
		// Act

		// Assert
		assertTrue(result, "Otp should be able to regenerate");
	}

	// not working
	@Test
	public void testIsOtpCanRegen_OtpCannotBeRegenerated()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		// Arrange
		OtpEntity otpEntity = new OtpEntity();
		otpEntity.setOtpGeneratedAt(Instant.now().minusSeconds(5)); // Otp generated 5 seconds ago
		Method isOtpCanRegen = OtpService.class.getDeclaredMethod("isOtpCanRegen", OtpEntity.class);
		isOtpCanRegen.setAccessible(true);

		// Invoke the private method
		boolean result = (boolean) isOtpCanRegen.invoke(otpService, otpEntity);
		// Act
		// Assert
		assertFalse(result, "Otp should not be able to regenerate");
	}

	@Test
	public void sendOtp_ShouldResendOtpWhenResendCountLeftTest()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {

		String ektp = "ygdyb";
		String email = "kapil44@gmail.com";
		String countryCode = "536365";
		String phoneNumber = "84676356477";

		OtpRequest request = new OtpRequest(/* provide necessary data */);

		request.setEktp(ektp);
		request.setEmail(email);
		request.setCountryCode(countryCode);
		request.setPhoneNumber(phoneNumber);

		/////////////////////////////////////////////////////////////////
		String mobileNumber = "84676356477";
		String ektpNumber = "ygdyb";
		String otp = "123456";
		Instant blockedUntil = Instant.parse("2023-12-13T12:00:00Z");

		int numberOfOtpLeft = 4;
		OtpValidationResult otpValidationResult = null;

		OtpResponse mockedOtpResponse = new OtpResponse();

		mockedOtpResponse.setEktpNumber(ektpNumber);
		mockedOtpResponse.setOtp(otp);
		mockedOtpResponse.setMobileNumber(mobileNumber);
		mockedOtpResponse.setBlockedUntil(blockedUntil);
		mockedOtpResponse.setOtpValidationResult(otpValidationResult);

		OtpRequest otpRequest = new OtpRequest();
		otpRequest.setEktp(ektp);
		otpRequest.setPhoneNumber(phoneNumber + countryCode);
		otpRequest.setCountryCode(countryCode);

		OtpRepositoryTest otpRepository = mock(OtpRepositoryTest.class);
		OtpEntity existingOtpEntity = new OtpEntity(/* fill with necessary data */);
		when(otpRepository.findByEktpNumber(otpRequest.getEktp())).thenReturn(Optional.of(existingOtpEntity));
		// when(otpService.isOtpCanRegen(existingOtpEntity)).thenReturn(true);
		when(otpRepository.save(any(OtpEntity.class))).thenReturn(null);

		Method isOtpCanRegen = OtpService.class.getDeclaredMethod("isOtpCanRegen", OtpEntity.class);
		isOtpCanRegen.setAccessible(true);
		// Test
		OtpResponse actualOtpResponse = otpService.sendOtp(otpRequest);

		// Assertions
		assertNotNull(actualOtpResponse.getOtp());
		verify(otpRepository, times(1)).save(any(OtpEntity.class));

	}

	@Test
	public void sendOtp_ShouldHandleCaseWhenUserIsBlocked() {
		// Mock data

		String ektp = "ygdyb";
		String email = "kapil44@gmail.com";
		String countryCode = "536365";
		String phoneNumber = "84676356477";

		OtpRequest request = new OtpRequest(/* provide necessary data */);

		request.setEktp(ektp);
		request.setEmail(email);
		request.setCountryCode(countryCode);
		request.setPhoneNumber(phoneNumber);

		/////////////////////////////////////////////////////////////////
		String mobileNumber = "84676356477";
		String ektpNumber = "ygdyb";
		String otp = "123456";
		Instant blockedUntil = Instant.parse("2023-12-13T12:00:00Z");

		int numberOfOtpLeft = 4;
		OtpValidationResult otpValidationResult = null;

		OtpResponse mockedOtpResponse = new OtpResponse();

		mockedOtpResponse.setEktpNumber(ektpNumber);
		mockedOtpResponse.setOtp(otp);
		mockedOtpResponse.setMobileNumber(mobileNumber);
		mockedOtpResponse.setBlockedUntil(blockedUntil);
		mockedOtpResponse.setOtpValidationResult(otpValidationResult);

		OtpRequest otpRequest = new OtpRequest();
		otpRequest.setEktp(ektp);
		otpRequest.setPhoneNumber(phoneNumber + countryCode);
		otpRequest.setCountryCode(countryCode);

		OtpEntity existingOtpEntity = new OtpEntity();
		existingOtpEntity.setBlockedUntil(null);
		existingOtpEntity.setNumberOfOtpGenerated(2);

		OtpEntity otpEntity = new OtpEntity(/* fill with necessary data */);
		existingOtpEntity.setBlockedUntil(Instant.now().plusSeconds(60)); // Simulate a blocked user
		when(otpRepository.findByEktpNumber(request.getEktp())).thenReturn(Optional.of(existingOtpEntity));

		// Test
		OtpResponse otpResponse = otpService.sendOtp(otpRequest);

		// Assertions
		assertNull(otpResponse.getOtp());
		assertEquals(OtpValidationResult.USER_IS_BLOCKED, otpResponse.getOtpValidationResult());
		assertNotNull(otpResponse.getBlockedUntil());
	}

	@Test
	public void GenerateOtpLengthTest() {

		OtpEntity entity = new OtpEntity();

		OtpService otpService = new OtpService();

		// Act
		String generatedOtp = otpService.generateOtp();

		// Assert

		assertNotNull(generatedOtp, "Generated OTP should not be null");
		assertEquals(6, generatedOtp.length(), "Generated OTP should have a length of 6");
		assertNotEquals(6, generatedOtp);
	}

	@Test
	public void testIsUserBlocked_UserNotBlocked()
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		OtpService otpService = new OtpService();
		OtpEntity otpEntity = new OtpEntity(/* fill with necessary data */);

		Method isUserBlockedMethod = OtpService.class.getDeclaredMethod("isUserBlocked", OtpEntity.class);
		isUserBlockedMethod.setAccessible(true);

		// Invoke the private method
		boolean result = (boolean) isUserBlockedMethod.invoke(otpService, otpEntity);

		// Assertions
		assertFalse(result, "User should not be blocked");
		verify(otpRepository, times(1)).save(otpEntity);
	}

	@Test
	public void testIsUserBlocked_UserUnblocked() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		OtpEntity otpEntity = new OtpEntity(/* fill with necessary data */);
		otpEntity.setBlockedUntil(Instant.now().minusSeconds(60)); // Assume blocked for 60 seconds

		Method isUserBlockedMethod = OtpService.class.getDeclaredMethod("isUserBlocked", OtpEntity.class);
		isUserBlockedMethod.setAccessible(true);

		// Invoke the private method
		boolean result = (boolean) isUserBlockedMethod.invoke(otpService, otpEntity);

		assertFalse(result, "User should not be blocked");

		// Ensure that the save method is called once
		verify(otpRepository, times(1)).save(otpEntity);
	}

	@Test
	void testIsUserBlockedWhenBlocked() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		OtpEntity otpEntity = new OtpEntity();
		otpEntity.setBlockedUntil(Instant.now().plusSeconds(60)); // Assuming the user is blocked for 60 seconds

		Method isUserBlockedMethod = OtpService.class.getDeclaredMethod("isUserBlocked", OtpEntity.class);
		isUserBlockedMethod.setAccessible(true);

		// Invoke the private method
		boolean result = (boolean) isUserBlockedMethod.invoke(otpService, otpEntity);
		assertTrue(result, "User should not be blocked");
	}

	@Test
	public void saveOtpData_WhenOtpEntityExists_ShouldUpdateOtpEntity() {
		// Arrange

		String mobileNumber = "1234567890";
		String ektpNumber = "EKTP123";
		String otp = "123456";

		OtpEntity existingOtpEntity = new OtpEntity();
		existingOtpEntity.setEktpNumber(ektpNumber);

		Optional<OtpEntity> otpEntityOptional = Optional.of(existingOtpEntity);

		Mockito.when(otpRepository.findByEktpNumber(ektpNumber)).thenReturn(otpEntityOptional);

		OtpService otpService = new OtpService();
		// Act
		otpService.saveOtpData(mobileNumber, ektpNumber, otp);

		// Assert
		Mockito.verify(otpRepository, Mockito.times(1)).save(existingOtpEntity);

		assertEquals(mobileNumber, existingOtpEntity.getMobileNumber());
		assertEquals(otp, existingOtpEntity.getOtp());
		assertNotNull(existingOtpEntity.getOtpGeneratedAt());
		assertEquals(1, existingOtpEntity.getNumberOfOtpGenerated());
	}

	@Test
	public void saveOtpData_WhenOtpEntityDoesNotExist_ShouldCreateNewOtpEntity() {
		// Arrange
		String mobileNumber = "1234567890";
		String ektpNumber = "EKTP123";
		String otp = "123456";

		Optional<OtpEntity> otpEntityOptional = Optional.empty();

		Mockito.when(otpRepository.findByEktpNumber(ektpNumber)).thenReturn(otpEntityOptional);
		OtpService otpService = new OtpService();
		// Act

		// Act
		otpService.saveOtpData(mobileNumber, ektpNumber, otp);

		// Assert
		Mockito.verify(otpRepository, Mockito.times(1)).save(Mockito.any(OtpEntity.class));
	}

}
