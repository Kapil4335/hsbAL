package com.crif.cff.brk.hsbcb.routes.vida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaTokenResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaTokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/vida/api/v1")
public class VidaAuthTokenController {

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaAuthTokenController.class);

	@Autowired
	private VidaTokenService vidaTokenService;
	
	@GetMapping("/authtoken")
	public VidaTokenResponseDto getVidaAuthToken() {
		LOGGER.debug( this.getClass().getSimpleName() + " : in token controller calling /vida/authtoken" );
		return vidaTokenService.getVidaAuthToken();
	}
	
	@GetMapping("/authtokenexpired")
	public boolean getAuthStatus() {
		LOGGER.debug( this.getClass().getSimpleName() + " : in token controller calling /vida/authtokenexpired" );
		return vidaTokenService.isAccessTokenExpired();
	}
	
	@GetMapping("/accesstoken")
	public String getAuthStatustoken() {
		LOGGER.debug( this.getClass().getSimpleName() + " : in token controller calling /vida/accesstoken" );
		return vidaTokenService.getAccessToken();
	}
	
	@GetMapping("/refreshtoken")
	public VidaTokenResponseDto getAuthStatustoken2()throws JsonMappingException, JsonProcessingException {
		LOGGER.debug( this.getClass().getSimpleName() + " : in token controller calling /vida/refreshtoken" );
		return vidaTokenService.refreshToken();
	}    
}
