package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SigningInfo {

	@JsonProperty("pdfFile")	
	private String pdfFile;

	@JsonProperty("appearance")
	private Appearance appearance;

	@JsonProperty("pageNo")
	private String pageNo;

	@JsonProperty("xPoint")
	private String xPoint;

	@JsonProperty("yPoint")
	private String yPoint;

	@JsonProperty("height")
	private String height;

	@JsonProperty("width")
	private String width;

	@JsonProperty("pdfTemplateId")
	private String pdfTemplateId;

	@JsonProperty("formValues")
	private FormValues formValues;

	@JsonProperty("formFields")
	private ArrayList<FormField> formFields;

	public String getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}

	public Appearance getAppearance() {
		return appearance;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getxPoint() {
		return xPoint;
	}

	public void setxPoint(String xPoint) {
		this.xPoint = xPoint;
	}

	public String getyPoint() {
		return yPoint;
	}

	public void setyPoint(String yPoint) {
		this.yPoint = yPoint;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getPdfTemplateId() {
		return pdfTemplateId;
	}

	public void setPdfTemplateId(String pdfTemplateId) {
		this.pdfTemplateId = pdfTemplateId;
	}

	public FormValues getFormValues() {
		return formValues;
	}

	public void setFormValues(FormValues formValues) {
		this.formValues = formValues;
	}

	public ArrayList<FormField> getFormFields() {
		return formFields;
	}

	public void setFormFields(ArrayList<FormField> formFields) {
		this.formFields = formFields;
	}

	@Override
	public String toString() {
		return "SigningInfo [pdfFile=" + pdfFile + ", appearance=" + appearance + ", pageNo=" + pageNo + ", xPoint="
				+ xPoint + ", yPoint=" + yPoint + ", height=" + height + ", width=" + width + ", pdfTemplateId="
				+ pdfTemplateId + ", formValues=" + formValues + ", formFields=" + formFields + "]";
	}
	
	
}
