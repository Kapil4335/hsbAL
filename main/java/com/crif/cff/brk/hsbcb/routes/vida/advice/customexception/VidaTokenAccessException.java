package com.crif.cff.brk.hsbcb.routes.vida.advice.customexception;

import org.springframework.http.HttpStatus;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaTokenResponseDto;

public class VidaTokenAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private VidaTokenResponseDto vidaTokenResponse;
	private HttpStatus httpStatus;

	public VidaTokenAccessException(VidaTokenResponseDto vidaTokenResponse, Exception e, HttpStatus httpStatus) {
		super(e);
		this.vidaTokenResponse = vidaTokenResponse;
		this.httpStatus = httpStatus;
	}

	public VidaTokenAccessException(VidaTokenResponseDto vidaTokenResponse, Throwable e, HttpStatus httpStatus) {
		super(e);
		this.vidaTokenResponse = vidaTokenResponse;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public VidaTokenResponseDto getVidaTokenResponse() {
		return vidaTokenResponse;
	}

}
