package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignedDocDto {

	@JsonProperty("pdfTemplateId")
	private String pdfTemplateId;
	
	@JsonProperty("documentUrl")
	private String documentUrl;

	@JsonProperty("code")
	private int code;
	
	@JsonProperty("errMsg")
	private String errMsg;

	public String getPdfTemplateId() {
		return pdfTemplateId;
	}

	public void setPdfTemplateId(String pdfTemplateId) {
		this.pdfTemplateId = pdfTemplateId;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "SignedDoc [pdfTemplateId=" + pdfTemplateId + ", documentUrl=" + documentUrl + ", code=" + code
				+ ", errMsg=" + errMsg + "]";
	}

}
