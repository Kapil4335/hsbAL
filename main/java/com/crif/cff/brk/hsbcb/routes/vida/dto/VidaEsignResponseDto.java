package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaEsignResponseDto {

	@JsonProperty("data")
	private EsignDataDto data;
	
	@JsonProperty("errors")
	public ArrayList<VidaErrorsDto> errors;

	public EsignDataDto getData() {
		return data;
	}

	public void setData(EsignDataDto data) {
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
		return "VidaEsignResponseDto [data=" + data + ", errors=" + errors + "]";
	}

}
