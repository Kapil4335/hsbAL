package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

	@JsonProperty("os")
	private String os;

	@JsonProperty("model")
	private String model;

	@JsonProperty("uniqueId")
	private String uniqueId;

	@JsonProperty("networkProvider")	
	private String networkProvider;

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getNetworkProvider() {
		return networkProvider;
	}

	public void setNetworkProvider(String networkProvider) {
		this.networkProvider = networkProvider;
	}

	@Override
	public String toString() {
		return "Device [os=" + os + ", model=" + model + ", uniqueId=" + uniqueId + ", networkProvider="
				+ networkProvider + "]";
	}
	
}
