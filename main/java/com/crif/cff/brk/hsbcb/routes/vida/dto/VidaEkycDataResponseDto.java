package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaEkycDataResponseDto {

	@JsonProperty("data")
	private EkycDataDto ekycData;
	
	@JsonProperty("errors")
	public ArrayList<VidaErrorsDto> errors;
	
	public ArrayList<VidaErrorsDto> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<VidaErrorsDto> errors) {
		this.errors = errors;
	}

	@JsonProperty("timestamp")
	private Date timestamp;
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("error")
	private String error;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("path")
	private String path;

	public EkycDataDto getEkycData() {
		return ekycData;
	}

	public void setEkycData(EkycDataDto ekycData) {
		this.ekycData = ekycData;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "VidaEkycDataResponseDto [ekycData=" + ekycData + ", errors=" + errors + ", timestamp=" + timestamp
				+ ", status=" + status + ", error=" + error + ", message=" + message + ", path=" + path + "]";
	}
	
}
