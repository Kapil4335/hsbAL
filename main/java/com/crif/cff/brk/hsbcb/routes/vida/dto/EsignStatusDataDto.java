package com.crif.cff.brk.hsbcb.routes.vida.dto;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EsignStatusDataDto {

	@JsonProperty("partnerTrxId") 
    private String partnerTrxId;
	
    @JsonProperty("code")
    private int code;
    
    @JsonProperty("lastUpdateAt")
    private Date lastUpdateAt;
    
    @JsonProperty("signedDocs")
    private ArrayList<SignedDocDto> signedDocs;
    
    @JsonProperty("errorCode")
    private int errorCode;
    
    @JsonProperty("failureReason")
    private String failureReason;

	public String getPartnerTrxId() {
		return partnerTrxId;
	}

	public void setPartnerTrxId(String partnerTrxId) {
		this.partnerTrxId = partnerTrxId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getLastUpdateAt() {
		return lastUpdateAt;
	}

	public void setLastUpdateAt(Date lastUpdateAt) {
		this.lastUpdateAt = lastUpdateAt;
	}

	public ArrayList<SignedDocDto> getSignedDocs() {
		return signedDocs;
	}

	public void setSignedDocs(ArrayList<SignedDocDto> signedDocs) {
		this.signedDocs = signedDocs;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	@Override
	public String toString() {
		return "EsignStatusData [partnerTrxId=" + partnerTrxId + ", code=" + code + ", lastUpdateAt=" + lastUpdateAt
				+ ", signedDocs=" + signedDocs + ", errorCode=" + errorCode + ", failureReason=" + failureReason + "]";
	}
    
    
}
