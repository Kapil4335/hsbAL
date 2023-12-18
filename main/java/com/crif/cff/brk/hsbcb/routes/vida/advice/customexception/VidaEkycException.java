package com.crif.cff.brk.hsbcb.routes.vida.advice.customexception;

import org.springframework.http.HttpStatus;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;

public class VidaEkycException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private VidaEkycResponseDto vidaEkycResponse;
	private HttpStatus httpStatus;

	public VidaEkycException(VidaEkycResponseDto vidaEkycResponse, Exception e, HttpStatus httpStatus) {
		super(e);
		this.vidaEkycResponse = vidaEkycResponse;
		this.httpStatus = httpStatus;
	}

	public VidaEkycException(VidaEkycResponseDto vidaEkycResponse, Throwable e, HttpStatus httpStatus) {
		super(e);
		this.vidaEkycResponse = vidaEkycResponse;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public VidaEkycResponseDto getVidaEkycResponse() {
		return vidaEkycResponse;
	}

}
