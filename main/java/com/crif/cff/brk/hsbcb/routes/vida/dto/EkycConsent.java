package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EkycConsent {

	@JsonProperty("consentedAt")
	private String consentedAt;

	@JsonProperty("consentGiven")
	private boolean consentGiven;

	public String getConsentedAt() {
		return consentedAt;
	}

	public void setConsentedAt(String consentedAt) {
		this.consentedAt = consentedAt;
	}

	public boolean isConsentGiven() {
		return consentGiven;
	}

	public void setConsentGiven(boolean consentGiven) {
		this.consentGiven = consentGiven;
	}

	@Override
	public String toString() {
		return "EkycConsent [consentedAt=" + consentedAt + ", consentGiven=" + consentGiven + "]";
	}
	
	
}
