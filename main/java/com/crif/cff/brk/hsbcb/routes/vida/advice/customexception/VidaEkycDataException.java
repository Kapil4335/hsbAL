package com.crif.cff.brk.hsbcb.routes.vida.advice.customexception;

import org.springframework.http.HttpStatus;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;

public class VidaEkycDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private VidaEkycDataResponseDto vidaEkycDataResponse;
	private HttpStatus httpStatus;

	public VidaEkycDataException(VidaEkycDataResponseDto vidaEkycDataResponse, Exception e, HttpStatus httpStatus) {
		super(e);
		this.vidaEkycDataResponse = vidaEkycDataResponse;
		this.httpStatus = httpStatus;
	}

	public VidaEkycDataException(VidaEkycDataResponseDto vidaEkvidaEkycDataResponseycResponse, Throwable e, HttpStatus httpStatus) {
		super(e);
		this.vidaEkycDataResponse = vidaEkycDataResponse;
		this.httpStatus = httpStatus;
	}

	public VidaEkycDataResponseDto getVidaEkycDataResponse() {
		return vidaEkycDataResponse;
	}

	public void setVidaEkycDataResponse(VidaEkycDataResponseDto vidaEkycDataResponse) {
		this.vidaEkycDataResponse = vidaEkycDataResponse;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
