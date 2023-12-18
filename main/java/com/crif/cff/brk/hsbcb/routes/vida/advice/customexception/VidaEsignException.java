package com.crif.cff.brk.hsbcb.routes.vida.advice.customexception;

import org.springframework.http.HttpStatus;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;

public class VidaEsignException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private VidaEsignResponseDto vidaEsignResponse;
	private HttpStatus httpStatus;

	public VidaEsignException(VidaEsignResponseDto vidaEsignResponse, Exception e, HttpStatus httpStatus) {
		super(e);
		this.vidaEsignResponse = vidaEsignResponse;
		this.httpStatus = httpStatus;
	}

	public VidaEsignException(VidaEsignResponseDto vidaEsignResponse, Throwable e, HttpStatus httpStatus) {
		super(e);
		this.vidaEsignResponse = vidaEsignResponse;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public VidaEsignResponseDto getVidaEsignResponse() {
		return vidaEsignResponse;
	}

}
