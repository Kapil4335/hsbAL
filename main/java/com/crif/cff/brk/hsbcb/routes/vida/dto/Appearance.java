package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appearance {

	@JsonProperty("type")
	private String type;

	@JsonProperty("signImage")
	private String signImage;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSignImage() {
		return signImage;
	}

	public void setSignImage(String signImage) {
		this.signImage = signImage;
	}

	@Override
	public String toString() {
		return "Appearance [type=" + type + ", signImage=" + signImage + "]";
	}
	
}
