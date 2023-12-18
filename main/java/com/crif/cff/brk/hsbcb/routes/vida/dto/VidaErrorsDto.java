package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaErrorsDto {

	@JsonProperty("code")
	private int code;

	@JsonProperty("title")
	private String title;

	@JsonProperty("detail")
	private String detail;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "VidaErrorsDto [code=" + code + ", title=" + title + ", detail=" + detail + "]";
	}

}
