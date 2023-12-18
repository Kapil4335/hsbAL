package com.crif.cff.brk.hsbcb.routes.otp.model;

import java.time.Instant;

import com.crif.cff.brk.hsbcb.routes.otp.config.OtpValidationResult;


public class OtpResponse {

	private String mobileNumber;
	private String ektpNumber;
	private String otp;
	private Instant blockedUntil;
	private int numberOfOtpLeft;
	private OtpValidationResult otpValidationResult;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEktpNumber() {
		return ektpNumber;
	}
	public void setEktpNumber(String ektpNumber) {
		this.ektpNumber = ektpNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Instant getBlockedUntil() {
		return blockedUntil;
	}
	public void setBlockedUntil(Instant blockedUntil) {
		this.blockedUntil = blockedUntil;
	}
	public int getNumberOfOtpLeft() {
		return numberOfOtpLeft;
	}
	public void setNumberOfOtpLeft(int numberOfOtpLeft) {
		this.numberOfOtpLeft = numberOfOtpLeft;
	}
	public OtpValidationResult getOtpValidationResult() {
		return otpValidationResult;
	}
	public void setOtpValidationResult(OtpValidationResult otpValidationResult) {
		this.otpValidationResult = otpValidationResult;
	}
	
	
}
