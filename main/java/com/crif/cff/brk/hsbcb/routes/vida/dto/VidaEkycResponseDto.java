package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaEkycResponseDto {

	@JsonProperty("data")
	private EkycDto data;

	@JsonProperty("errors")
	private ArrayList<VidaErrorsDto> errors;

	@JsonProperty("error")
	private String error;

	@JsonProperty("error_description")
	private String errorDescription;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("status")
	private int status;

	@JsonProperty("message")
	private String message;

	@JsonProperty("path")
	private String path;

	public EkycDto getData() {
		return data;
	}

	public void setData(EkycDto data) {
		this.data = data;
	}

	public ArrayList<VidaErrorsDto> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<VidaErrorsDto> errors) {
		this.errors = errors;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		return "VidaEkycResponseDto [data=" + data + ", errors=" + errors + ", error=" + error + ", errorDescription="
				+ errorDescription + ", timestamp=" + timestamp + ", status=" + status + ", message=" + message
				+ ", path=" + path + "]";
	}

	
}
