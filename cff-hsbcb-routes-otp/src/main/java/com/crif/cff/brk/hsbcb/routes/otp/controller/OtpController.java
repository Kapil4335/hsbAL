package com.crif.cff.brk.hsbcb.routes.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crif.cff.brk.hsbcb.routes.otp.model.OtpRequest;
import com.crif.cff.brk.hsbcb.routes.otp.model.OtpResponse;
import com.crif.cff.brk.hsbcb.routes.otp.service.OtpService;


@RestController
@RequestMapping("/public/api/routes/otp")
public class OtpController {

	@Autowired
	OtpService otpService;
	
	@PostMapping("/send/mobile")
	public ResponseEntity<OtpResponse> sendOtp(@RequestBody OtpRequest otpRequest)
	{
		
		OtpResponse otpResponse=otpService.sendOtp(otpRequest);
		return ResponseEntity.ok(otpResponse);
		
	}
	
	@PostMapping("/validate")
	public ResponseEntity<OtpResponse> validateOtp(@RequestBody OtpRequest otpRequest, @RequestParam(name="receivedotp") String receivedOtp)
	{
		OtpResponse otpResponse=otpService.validateOtp(otpRequest, receivedOtp);
		return ResponseEntity.ok(otpResponse);
	}
}
