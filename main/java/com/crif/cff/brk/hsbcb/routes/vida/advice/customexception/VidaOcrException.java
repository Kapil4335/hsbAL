package com.crif.cff.brk.hsbcb.routes.vida.advice.customexception;

import org.springframework.http.HttpStatus;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;

public class VidaOcrException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private VidaOcrResponseDto vidaOcrResponse;
	private HttpStatus httpStatus;

	public VidaOcrException(VidaOcrResponseDto vidaOcrResponse, Exception e, HttpStatus httpStatus) {
		super(e);
		this.vidaOcrResponse = vidaOcrResponse;
		this.httpStatus = httpStatus;
	}

	public VidaOcrException(VidaOcrResponseDto vidaOcrResponse, Throwable e, HttpStatus httpStatus) {
		super(e);
		this.vidaOcrResponse = vidaOcrResponse;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public VidaOcrResponseDto getVidaOcrResponse() {
		return vidaOcrResponse;
	}

}
