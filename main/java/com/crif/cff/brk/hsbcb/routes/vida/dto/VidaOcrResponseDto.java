package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaOcrResponseDto {

	@JsonProperty("data")
	private OcrDataDto data;

	@JsonProperty("errors")
	private ArrayList<VidaErrorsDto> errors;

	public OcrDataDto getData() {
		return data;
	}

	public void setData(OcrDataDto data) {
		this.data = data;
	}

	public ArrayList<VidaErrorsDto> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<VidaErrorsDto> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "VidaOcrResponseDto [data=" + data + ", errors=" + errors + "]";
	}

}
