package com.crif.cff.brk.hsbcb.routes.vida.service;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaTokenResponseDto;

public interface VidaTokenService {

	public VidaTokenResponseDto getVidaAuthToken() ;
	
	public boolean isAccessTokenExpired() ;
	
	public VidaTokenResponseDto refreshToken();
	
	public String getAccessToken() ;
}
