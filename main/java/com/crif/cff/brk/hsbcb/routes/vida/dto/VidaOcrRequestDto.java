package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaOcrRequestDto {

	@JsonProperty("parameters")
	private OcrParameters parameters;

	public OcrParameters getParameters() {
		return parameters;
	}

	public void setParameters(OcrParameters parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "VidaOcrRequestDto [parameters=" + parameters + "]";
	}

}
