package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrParameters {

	@JsonProperty("ktp_image")
	private String ktpImage;

	public String getKtpImage() {
		return ktpImage;
	}

	public void setKtpImage(String ktpImage) {
		this.ktpImage = ktpImage;
	}

	@Override
	public String toString() {
		return "OcrParameters [ktpImage=" + ktpImage + "]";
	}
}
