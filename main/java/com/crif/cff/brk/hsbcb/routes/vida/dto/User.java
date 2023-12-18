package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("vidaEkycEventId")
	private String vidaEkycEventId;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("dob")
	private String dob;

	@JsonProperty("govId")
	private String govId;

	@JsonProperty("selfiePhoto")
	private String selfiePhoto;

	@JsonProperty("idCardPhoto")
	private String idCardPhoto;

	@JsonProperty("partnerId")
	private String partnerId;

	public String getVidaEkycEventId() {
		return vidaEkycEventId;
	}

	public void setVidaEkycEventId(String vidaEkycEventId) {
		this.vidaEkycEventId = vidaEkycEventId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@Override
	public String toString() {
		return "User [vidaEkycEventId=" + vidaEkycEventId + ", fullName=" + fullName + ", email=" + email + ", mobile="
				+ mobile + ", dob=" + dob + ", govId=" + govId + ", selfiePhoto=" + selfiePhoto + ", idCardPhoto="
				+ idCardPhoto + ", partnerId=" + partnerId + "]";
	}
	
}
