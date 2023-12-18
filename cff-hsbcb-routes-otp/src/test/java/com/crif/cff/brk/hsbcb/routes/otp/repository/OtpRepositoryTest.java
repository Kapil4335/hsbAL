package com.crif.cff.brk.hsbcb.routes.otp.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.crif.cff.brk.hsbcb.routes.otp.controller.OtpController;
import com.crif.cff.brk.hsbcb.routes.otp.entity.OtpEntity;
import com.crif.cff.brk.hsbcb.routes.otp.service.OtpService;

@ExtendWith(MockitoExtension.class)
@DataJpaTest

public class OtpRepositoryTest {

	@Mock
	private OtpEntity otpEntity;

	@Mock
	private OtpRepository otpRepository;

	@InjectMocks
	private OtpService otpService;

	@Mock
	private OtpController otpController;

	@Test
	public void FindByEktpNumberTest() {

		OtpService otpService = new OtpService();
		// Mock data
		String ektpNumber = "ektp456789";
		/*
		 * String mobileNumber = "78374652546";
		 * 
		 * String Otp = "123456";
		 */

		OtpEntity otpEntity = new OtpEntity(); // Create a sample OtpEntity

		// Mock behavior of the repository
		when(otpRepository.findByEktpNumber(ektpNumber)).thenReturn(Optional.of(otpEntity));

		// Call the service method that uses the repository
		// Optional<OtpEntity> result =otpRepository.findByEktpNumber(ektpNumber);

		Optional<OtpEntity> result = otpRepository.findByEktpNumber(ektpNumber);

		// Verify that the repository method was called with the correct parameter
		verify(otpRepository, times(1)).findByEktpNumber(ektpNumber);

		// Verify the result
		assertEquals(Optional.of(otpEntity), result);
	}

}
