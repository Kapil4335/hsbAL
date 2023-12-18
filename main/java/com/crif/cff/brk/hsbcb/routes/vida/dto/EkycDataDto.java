package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EkycDataDto {

	@JsonProperty("fullName")
	private String fullName;
	
	@JsonProperty("emailId")
	private String emailId;
	
	@JsonProperty("mobile")
	private String mobile;
	
	@JsonProperty("dob")
	private String dob;
	
	@JsonProperty("govId")
	private String govId;
	
	@JsonProperty("govIdType")
	private String govIdType;
	
	@JsonProperty("selfiePhoto")
	private String selfiePhoto;
	
	@JsonProperty("idCardPhoto")
	private String idCardPhoto;
	
	@JsonProperty("selfieScore")
	double selfieScore;
	
	@JsonProperty("certificateIssued")
	private int certificateIssued;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGovId() {
		return govId;
	}

	public void setGovId(String govId) {
		this.govId = govId;
	}

	public String getGovIdType() {
		return govIdType;
	}

	public void setGovIdType(String govIdType) {
		this.govIdType = govIdType;
	}

	public String getSelfiePhoto() {
		return selfiePhoto;
	}

	public void setSelfiePhoto(String selfiePhoto) {
		this.selfiePhoto = selfiePhoto;
	}

	public String getIdCardPhoto() {
		return idCardPhoto;
	}

	public void setIdCardPhoto(String idCardPhoto) {
		this.idCardPhoto = idCardPhoto;
	}

	public double getSelfieScore() {
		return selfieScore;
	}

	public void setSelfieScore(double selfieScore) {
		this.selfieScore = selfieScore;
	}

	public int getCertificateIssued() {
		return certificateIssued;
	}

	public void setCertificateIssued(int certificateIssued) {
		this.certificateIssued = certificateIssued;
	}

	@Override
	public String toString() {
		return "EkycData [fullName=" + fullName + ", emailId=" + emailId + ", mobile=" + mobile + ", dob=" + dob
				+ ", govId=" + govId + ", govIdType=" + govIdType + ", selfiePhoto=" + selfiePhoto + ", idCardPhoto="
				+ idCardPhoto + ", selfieScore=" + selfieScore + ", certificateIssued=" + certificateIssued + "]";
	}

}
