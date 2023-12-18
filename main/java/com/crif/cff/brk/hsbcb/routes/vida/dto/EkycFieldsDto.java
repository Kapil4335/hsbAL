package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EkycFieldsDto {

	@JsonProperty("score")
	private double score;

	@JsonProperty("field")
	private String field;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "EKycFieldsDto [score=" + score + ", field=" + field + "]";
	}

	
}
