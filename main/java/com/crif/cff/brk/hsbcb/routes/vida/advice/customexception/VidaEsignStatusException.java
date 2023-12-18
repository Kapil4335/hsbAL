package com.crif.cff.brk.hsbcb.routes.vida.advice.customexception;

import org.springframework.http.HttpStatus;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;

public class VidaEsignStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private VidaEsignStatusResponseDto vidaEsignStatusResponse;
	private HttpStatus httpStatus;

	public VidaEsignStatusException(VidaEsignStatusResponseDto vidaEsignStatusResponse, Exception e, HttpStatus httpStatus) {
		super(e);
		this.vidaEsignStatusResponse = vidaEsignStatusResponse;
		this.httpStatus = httpStatus;
	}

	public VidaEsignStatusException(VidaEsignStatusResponseDto vidaEsignStatusResponse, Throwable e, HttpStatus httpStatus) {
		super(e);
		this.vidaEsignStatusResponse = vidaEsignStatusResponse;
		this.httpStatus = httpStatus;
	}

	public VidaEsignStatusResponseDto getVidaEsignStatusResponse() {
		return vidaEsignStatusResponse;
	}

	public void setVidaEsignStatusResponse(VidaEsignStatusResponseDto vidaEsignStatusResponseDto) {
		this.vidaEsignStatusResponse = vidaEsignStatusResponseDto;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
}
