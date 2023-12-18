package com.crif.cff.brk.hsbcb.routes.otp.service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crif.cff.brk.hsbcb.routes.otp.config.OtpValidationResult;
import com.crif.cff.brk.hsbcb.routes.otp.entity.OtpEntity;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpRequest;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpResponse;
import com.crif.cff.brk.hsbcb.routes.otp.repository.OtpRepository;

@Service
public class OtpService {

	@Autowired
	OtpRepository otpRepository;
	
	@Value("${otp.length}")
	private int otpLength;
	
	@Value("${otp.retry.max}")
	private int maxRetryCount;
	
	@Value("${otp.resend.max}")
	private int otpResendMax;
	
	@Value("${otp.regen.after.seconds}")
	private int otpRegenAfterSeconds;
	
	
	@Value("${otp.validity.seconds}")
	private long otpValiditySeconds;
	
	@Value("${otp.block.duration.hours}")
	private int blockDurationHours;

	public String generateOtp()
	{
		SecureRandom secureRandom=new SecureRandom();
		String otpValue = String.valueOf(100000 + secureRandom.nextInt(900000));
			
		return otpValue;
	}
	
	public OtpResponse sendOtp(OtpRequest otpRequest)
	{
		System.out.println("OtpService.sendOtp()");
		OtpResponse otpResponse=new OtpResponse();
		otpResponse.setEktpNumber(otpRequest.getEktp());
		otpResponse.setMobileNumber(otpRequest.getPhoneNumberWithCountryCode());
		
		Optional<OtpEntity> otpEntityOptional= otpRepository.findByEktpNumber(otpRequest.getEktp());
		OtpEntity otpEntity;
		
		if(otpEntityOptional.isPresent())
		{
			otpEntity=otpEntityOptional.get();
			
			if(isUserBlocked(otpEntity))
			{
				otpResponse.setNumberOfOtpLeft(otpResendMax-otpEntity.getNumberOfOtpGenerated());
				otpResponse.setOtp(null);
				otpResponse.setOtpValidationResult(OtpValidationResult.USER_IS_BLOCKED);
				otpResponse.setBlockedUntil(otpEntity.getBlockedUntil());
				return otpResponse;
			}
			
		
			int otpResendCountLeft=otpResendMax-otpEntity.getNumberOfOtpGenerated();
			
			if(!isOtpCanRegen(otpEntity))
			{
				otpResponse.setOtp(null);
				otpResponse.setOtpValidationResult(OtpValidationResult.OTP_NOT_GENERATED);
				return otpResponse;
			}
			
			
			if(otpResendCountLeft>0)
			{
				String otp=generateOtp();
				saveOtpData(otpRequest.getPhoneNumberWithCountryCode(), otpRequest.getEktp(), otp);
				//This is implemented later in SMS integration brick
				//sendOtpSms(mobileNumber, otp);
				otpResponse.setNumberOfOtpLeft(otpResendCountLeft-1);
				otpResponse.setOtp(otp);
				otpResponse.setOtpValidationResult(null);
				otpResponse.setBlockedUntil(otpEntity.getBlockedUntil());
				return otpResponse;
			}
			else
			{
				otpResponse.setNumberOfOtpLeft(otpResendMax-otpEntity.getNumberOfOtpGenerated());
				otpResponse.setOtp(null);
				otpResponse.setOtpValidationResult(OtpValidationResult.OTP_LIMIT_EXCEED);
				otpResponse.setBlockedUntil(otpEntity.getBlockedUntil());
				return otpResponse;
			}
		}
		else
		{
			String otp=generateOtp();
			saveOtpData(otpRequest.getPhoneNumberWithCountryCode(), otpRequest.getEktp(), otp);
			otpResponse.setNumberOfOtpLeft(otpResendMax-1);
			otpResponse.setOtp(otp);
			otpResponse.setOtpValidationResult(null);
			otpResponse.setBlockedUntil(null);
			return otpResponse;
		}

	}
	
	private boolean isOtpCanRegen(OtpEntity otpEntity) {
		
		Instant otpGeneratedAt=otpEntity.getOtpGeneratedAt();
		Instant now=Instant.now();
		long reGenTimeMillis= otpRegenAfterSeconds * 1000;
		return otpGeneratedAt.plusMillis(reGenTimeMillis).isBefore(now);

	}

	@Transactional
	public void saveOtpData(String mobileNumber, String ektpNumber, String otp)
	{
		Optional<OtpEntity> otpEntityOptional= otpRepository.findByEktpNumber(ektpNumber);
		OtpEntity otpEntity;
		
		if(otpEntityOptional.isPresent())
		{
			otpEntity=otpEntityOptional.get();
		}
		else
		{
			otpEntity=new OtpEntity();
			otpEntity.setEktpNumber(ektpNumber);
			otpEntity.setBlockedUntil(null);
			otpEntity.setNumberOfRetry(0);
			otpEntity.setNumberOfOtpGenerated(0);
		}
		
		//store otp in DB
		otpEntity.setMobileNumber(mobileNumber);
		otpEntity.setOtp(otp);
		otpEntity.setOtpGeneratedAt(Instant.now());
		otpEntity.setNumberOfOtpGenerated(otpEntity.getNumberOfOtpGenerated()+1);
		
		otpRepository.save(otpEntity);
	}
	
	@Transactional
	public OtpResponse validateOtp(OtpRequest otpRequest, String receivedOtp)
	{
		Optional<OtpEntity> otpEntityOptional= otpRepository.findByEktpNumber(otpRequest.getEktp());
		OtpResponse otpResponse=new OtpResponse();
		otpResponse.setEktpNumber(otpRequest.getEktp());
		otpResponse.setMobileNumber(otpRequest.getPhoneNumberWithCountryCode());
		
		if(otpEntityOptional.isPresent())
		{
			OtpEntity otpEntity=otpEntityOptional.get();
			otpResponse.setBlockedUntil(otpEntity.getBlockedUntil());
			otpResponse.setNumberOfOtpLeft(otpResendMax-otpEntity.getNumberOfOtpGenerated());
		
			//Check if the user is currently blocked
			if(isUserBlocked(otpEntity))
			{
				//User is still blocked
				otpResponse.setOtpValidationResult(OtpValidationResult.USER_IS_BLOCKED);
				return otpResponse;
			}
			
			// Check the Mobile Number is valid
			if(!isValidMobileNumber(otpRequest.getPhoneNumberWithCountryCode(), otpEntity.getMobileNumber()))
			{
				otpResponse.setOtpValidationResult(OtpValidationResult.INVALID_OTP);				
				return otpResponse;
			}
			
			
			// Validate the OTP
			if(isValidOtp(receivedOtp, otpEntity.getOtp()))
			{
				// Check the Otp has expired
				if(!isWithinValidity(otpEntity))
				{
					otpResponse.setOtpValidationResult(OtpValidationResult.OTP_EXPIRED);				
					return otpResponse;
				}
				
				// Valid OTP, update time and reset count
				otpEntity.setLastValidatedAt(Instant.now());
				otpEntity.setNumberOfRetry(0);
				otpEntity.setBlockedUntil(null);
				otpEntity.setNumberOfOtpGenerated(0);
				otpRepository.save(otpEntity);
				
				otpResponse.setBlockedUntil(null);
				otpResponse.setOtpValidationResult(OtpValidationResult.OTP_VALIDATED);				
				return otpResponse;
			
			}
			else
			{
				//Invalid OTP, update retry count and time
				otpEntity.setNumberOfRetry(otpEntity.getNumberOfRetry()+1);
				
				//Check if the retry count has reached the limit for blocking
				if(otpEntity.getNumberOfRetry()>=maxRetryCount)
				{
					// blocked the user for specified time
					//otpEntity.setBlockedUntil(System.currentTimeMillis() + blockDurationHours * 60 * 60 * 1000);
					otpEntity.setBlockedUntil(Instant.now().plusSeconds(blockDurationHours * 60 * 60));					
					otpRepository.save(otpEntity);
					otpResponse.setBlockedUntil(otpEntity.getBlockedUntil());
					otpResponse.setOtpValidationResult(OtpValidationResult.USER_BLOCKED);				
					return otpResponse;
						
				}
				
				otpRepository.save(otpEntity);
				otpResponse.setOtpValidationResult(OtpValidationResult.INVALID_OTP);				
				return otpResponse;
				
			}
			
		}
		otpResponse.setOtpValidationResult(OtpValidationResult.USER_NOT_FOUND);				
		return otpResponse;
	}

	private boolean isValidMobileNumber(String providedMobileNumber, String mobileNumber) {
		
		return providedMobileNumber.equals(mobileNumber);
	}

	private boolean isValidOtp(String providedOtp, String otp) {
		
		return providedOtp.equals(otp);
	}

	private boolean isWithinValidity(OtpEntity otpEntity) {
		
		// Check if the last retry time is within the validity time window;
		//		long currentTime= System.currentTimeMillis();
		//		long validityTimeMillis= otpValiditySeconds * 1000;
		//		return (otpGeneratedAt + validityTimeMillis) >= currentTime;
		Instant otpGeneratedAt=otpEntity.getOtpGeneratedAt();
		Instant now=Instant.now();
		long validityTimeMillis= otpValiditySeconds * 1000;
		return otpGeneratedAt.plusMillis(validityTimeMillis).isAfter(now);
		
	}

	@Transactional
	private boolean isUserBlocked(OtpEntity otpEntity) 
	{
		//Check if the user is currently blocked
		
		if(otpEntity.getBlockedUntil()==null)
		{
			return false;
		}
		
		//if(otpEntity.getBlockedUntil() > System.currentTimeMillis())
		if(otpEntity.getBlockedUntil().isAfter(Instant.now()))
		{
			// user is still blocked
			return true;
		}
		else if( null != otpEntity.getBlockedUntil()) 
		{
			// The block period has expired, reset the blocking information
			otpEntity.setBlockedUntil(null);
			
			// Reset the retry count
			otpEntity.setNumberOfRetry(0);
			otpEntity.setNumberOfOtpGenerated(0);
			otpRepository.save(otpEntity);
		}
		return false;
	}
}
