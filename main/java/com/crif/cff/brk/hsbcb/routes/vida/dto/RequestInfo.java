package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestInfo {

	@JsonProperty("userAgent")
	private String userAgent;

	@JsonProperty("srcIp")
	private String srcIp;

	@JsonProperty("consentTimestamp")
	private Instant consentTimestamp;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getSrcIp() {
		return srcIp;
	}

	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}

	public Instant getConsentTimestamp() {
		return consentTimestamp;
	}

	public void setConsentTimestamp(Instant consentTimestamp) {
		this.consentTimestamp = consentTimestamp;
	}

	@Override
	public String toString() {
		return "RequestInfo [userAgent=" + userAgent + ", srcIp=" + srcIp + ", consentTimestamp=" + consentTimestamp
				+ "]";
	}
	
}
