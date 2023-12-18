package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class VidaTokenResponseDto {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private String expiresIn;

	@JsonProperty("refresh_expires_in")
	private String refreshExpiresIn;

	@JsonProperty("refresh_token")
	private String refreshToken;

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("not-before-policy")
	private Date notBeforePolicy;

	@JsonProperty("session_state")
	private String sessionState;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("error")
	private String error;

	@JsonProperty("error_description")
	private String errorDescription;

	private Instant expirationTime;

	public Instant getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Instant expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshExpiresIn() {
		return refreshExpiresIn;
	}

	public void setRefreshExpiresIn(String refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getNotBeforePolicy() {
		return notBeforePolicy;
	}

	public void setNotBeforePolicy(Date notBeforePolicy) {
		this.notBeforePolicy = notBeforePolicy;
	}

	public String getSessionState() {
		return sessionState;
	}

	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@Override
	public String toString() {
		return "VidaTokenResponseDto [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", refreshExpiresIn="
				+ refreshExpiresIn + ", refreshToken=" + refreshToken + ", tokenType=" + tokenType
				+ ", notBeforePolicy=" + notBeforePolicy + ", sessionState=" + sessionState + ", scope=" + scope
				+ ", error=" + error + ", errorDescription=" + errorDescription + ", expirationTime=" + expirationTime
				+ "]";
	}
	
}
