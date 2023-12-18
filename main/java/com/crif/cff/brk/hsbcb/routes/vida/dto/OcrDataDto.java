package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrDataDto {

	@JsonProperty("result")
	private OcrResultDto result;

	@JsonProperty("status")
	private String status;

	@JsonProperty("transaction_id")
	private String transaction_id;

	public OcrResultDto getResult() {
		return result;
	}

	public void setResult(OcrResultDto result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	@Override
	public String toString() {
		return "OcrDataDto [result=" + result + ", status=" + status + ", transaction_id=" + transaction_id + "]";
	}

}
