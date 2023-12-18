package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EkycDto {

	@JsonProperty("eventId")
	private String eventId;

	@JsonProperty("fields")
	private ArrayList<EkycFieldsDto> fields;

	@JsonProperty("certificateIssued")
	private int certificateIssued;
	
	@JsonProperty("errorCode")
	private int errorCode;
	
	@JsonProperty("failureReason")
	private int failureReason;
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(int failureReason) {
		this.failureReason = failureReason;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public ArrayList<EkycFieldsDto> getFields() {
		return fields;
	}

	public void setFields(ArrayList<EkycFieldsDto> fields) {
		this.fields = fields;
	}

	public int getCertificateIssued() {
		return certificateIssued;
	}

	public void setCertificateIssued(int certificateIssued) {
		this.certificateIssued = certificateIssued;
	}

	@Override
	public String toString() {
		return "EKycDataDto [eventId=" + eventId + ", fields=" + fields + ", certificateIssued=" + certificateIssued
				+ ", errorCode=" + errorCode + ", failureReason=" + failureReason + "]";
	}

	
}
