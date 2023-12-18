package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormValues {

	@JsonProperty("formField1")
	private String formField1;

	@JsonProperty("formField2")
	private String formField2;

	public String getFormField1() {
		return formField1;
	}

	public void setFormField1(String formField1) {
		this.formField1 = formField1;
	}

	public String getFormField2() {
		return formField2;
	}

	public void setFormField2(String formField2) {
		this.formField2 = formField2;
	}

	@Override
	public String toString() {
		return "FormValues [formField1=" + formField1 + ", formField2=" + formField2 + "]";
	}
	
}
