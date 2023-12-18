package com.crif.cff.brk.hsbcb.routes.otp.entity;

//import com.crif.cff.shared.commons.jpa.PersistenceConstants;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
CREATE SCHEMA IF NOT EXISTS HsbcCustomData;

CREATE TABLE IF NOT EXISTS HsbcCustomData.OTP_DATA (
    ID 							Long 			PRIMARY KEY,
    MOBILE_NUMBER 				VARCHAR(255) 	NOT NULL,
    EKTP_NUMBER 				VARCHAR(16) 	NOT NULL,
    OTP_VALUE 					VARCHAR(10) 	NOT NULL,
    NUMBER_OF_RETRY 			INT 			DEFAULT 0, 	
    TOTAL_OTP_GENERATED		 	INT 			DEFAULT 0,
    OTP_GENERATED_AT 			TIMESTAMP 		DEFAULT CURRENT_TIMESTAMP,
    LAST_VALIDATED_AT	 		TIMESTAMP		NULL,
    BLOCKED_UNTIL 				TIMESTAMP		NULL
);

CREATE INDEX idx_ektp_number
ON OTP_DATA (EKTP_NUMBER);OTP_DATA (EKTP_NUMBER);

 */

@Entity
@Table(name = "OTP_DATA", schema = "cfcustom")
public class OtpEntity {

	@Id
	@Column(name = "OTP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long otpID;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "EKTP_NUMBER")
	private String ektpNumber;
	
	@Column(name = "OTP_VALUE")
	private String otp;
	
	@Column(name = "NUMBER_OF_RETRY")
	private int numberOfRetry;
	
	@Column(name = "OTP_GENERATED_AT")
	private Instant otpGeneratedAt;
	
	@Column(name = "LAST_VALIDATED_AT", nullable=true)
	private Instant lastValidatedAt;
	
	@Column(name = "BLOCKED_UNTIL", nullable=true)
	private Instant blockedUntil;
	
	@Column(name = "TOTAL_OTP_GENERATED")
	private int numberOfOtpGenerated;


	public Long getOtpID() {
		return otpID;
	}

	public void setOtpID(Long otpID) {
		this.otpID = otpID;
	}

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

	public int getNumberOfRetry() {
		return numberOfRetry;
	}

	public void setNumberOfRetry(int numberOfRetry) {
		this.numberOfRetry = numberOfRetry;
	}

	public Instant getOtpGeneratedAt() {
		return otpGeneratedAt;
	}

	public void setOtpGeneratedAt(Instant otpGeneratedAt) {
		this.otpGeneratedAt = otpGeneratedAt;
	}

	public Instant getLastValidatedAt() {
		return lastValidatedAt;
	}

	public void setLastValidatedAt(Instant lastValidatedAt) {
		this.lastValidatedAt = lastValidatedAt;
	}

	public Instant getBlockedUntil() {
		return blockedUntil;
	}

	public void setBlockedUntil(Instant blockedUntil) {
		this.blockedUntil = blockedUntil;
	}

	public int getNumberOfOtpGenerated() {
		return numberOfOtpGenerated;
	}

	public void setNumberOfOtpGenerated(int numberOfOtpGenerated) {
		this.numberOfOtpGenerated = numberOfOtpGenerated;
	}

		
}
