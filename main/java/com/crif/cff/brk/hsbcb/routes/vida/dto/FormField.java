package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormField {

	@JsonProperty("type")	
	private String type;

	@JsonProperty("name")
	private String name;

	@JsonProperty("value")
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FormField [type=" + type + ", name=" + name + ", value=" + value + "]";
	}

}
