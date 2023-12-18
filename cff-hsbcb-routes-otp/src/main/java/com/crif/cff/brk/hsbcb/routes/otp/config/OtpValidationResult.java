package com.crif.cff.brk.hsbcb.routes.otp.config;

public enum OtpValidationResult {
	
    OTP_VALIDATED("OTP validated successfully"),
    INVALID_OTP("OTP is not valid"),
    USER_BLOCKED("User blocked for 24 hours"),
    USER_IS_BLOCKED("User is blocked, retry after 24 hours"),
    USER_NOT_FOUND("User not found"),
    OTP_EXPIRED("OTP expired"),
	OTP_LIMIT_EXCEED("OTP limit exceed"),
	OTP_NOT_GENERATED("Retry after some time");

    private final String message;

    OtpValidationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

