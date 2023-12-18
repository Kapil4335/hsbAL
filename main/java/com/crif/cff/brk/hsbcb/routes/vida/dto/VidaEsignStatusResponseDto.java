package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaEsignStatusResponseDto {

	@JsonProperty("data")
	private EsignStatusDataDto data;

	@JsonProperty("errors")
	private ArrayList<VidaErrorsDto> errors;

	public EsignStatusDataDto getData() {
		return data;
	}

	public void setData(EsignStatusDataDto data) {
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
		return "VidaEsignStatusResponseDto [data=" + data + ", errors=" + errors + "]";
	}

}
