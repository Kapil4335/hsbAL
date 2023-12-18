package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaEsignRequestDto {

	@JsonProperty("partnerTrxId")
	private String partnerTrxId;

	@JsonProperty("user")
	private User user;

	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;

	@JsonProperty("device")
	private Device device;

	@JsonProperty("signingInfo")
	private ArrayList<SigningInfo> signingInfo;

	public String getPartnerTrxId() {
		return partnerTrxId;
	}

	public void setPartnerTrxId(String partnerTrxId) {
		this.partnerTrxId = partnerTrxId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public ArrayList<SigningInfo> getSigningInfo() {
		return signingInfo;
	}

	public void setSigningInfo(ArrayList<SigningInfo> signingInfo) {
		this.signingInfo = signingInfo;
	}

	@Override
	public String toString() {
		return "VidaEsignRequestDto [partnerTrxId=" + partnerTrxId + ", user=" + user + ", requestInfo=" + requestInfo
				+ ", device=" + device + ", signingInfo=" + signingInfo + "]";
	}	
	
}
