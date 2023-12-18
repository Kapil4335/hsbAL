package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VidaEkycRequestDto {

	@JsonProperty("partnerTrxId")
	private String partnerTrxId;

	@JsonProperty("mobile")	
	private String mobile;

	@JsonProperty("email")
	private String email;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("dob")	
	private String dob;

	@JsonProperty("govId")
	private String govId;

	@JsonProperty("motherMaidenName")
	private String motherMaidenName;

	@JsonProperty("familyCardNo")
	private String familyCardNo;

	@JsonProperty("pob")
	private String pob;

	@JsonProperty("address")
	private String address;

	@JsonProperty("village")
	private String village;

	@JsonProperty("district")
	private String district;

	@JsonProperty("city")
	private String city;

	@JsonProperty("province")
	private String province;

	@JsonProperty("selfiePhoto")
	private String selfiePhoto;

	@JsonProperty("idCardPhoto")
	private String idCardPhoto;

	@JsonProperty("consent")
	private EkycConsent ekycConsent;

	public String getPartnerTrxId() {
		return partnerTrxId;
	}

	public void setPartnerTrxId(String partnerTrxId) {
		this.partnerTrxId = partnerTrxId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGovId() {
		return govId;
	}

	public void setGovId(String govId) {
		this.govId = govId;
	}

	public String getMotherMaidenName() {
		return motherMaidenName;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}

	public String getFamilyCardNo() {
		return familyCardNo;
	}

	public void setFamilyCardNo(String familyCardNo) {
		this.familyCardNo = familyCardNo;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSelfiePhoto() {
		return selfiePhoto;
	}

	public void setSelfiePhoto(String selfiePhoto) {
		this.selfiePhoto = selfiePhoto;
	}

	public String getIdCardPhoto() {
		return idCardPhoto;
	}

	public void setIdCardPhoto(String idCardPhoto) {
		this.idCardPhoto = idCardPhoto;
	}

	public EkycConsent getEkycConsent() {
		return ekycConsent;
	}

	public void setEkycConsent(EkycConsent ekycConsent) {
		this.ekycConsent = ekycConsent;
	}

	@Override
	public String toString() {
		return "VidaEkycRequestDto2 [partnerTrxId=" + partnerTrxId + ", mobile=" + mobile + ", email=" + email
				+ ", fullName=" + fullName + ", dob=" + dob + ", govId=" + govId + ", motherMaidenName="
				+ motherMaidenName + ", familyCardNo=" + familyCardNo + ", pob=" + pob + ", address=" + address
				+ ", village=" + village + ", district=" + district + ", city=" + city + ", province=" + province
				+ ", selfiePhoto=" + selfiePhoto + ", idCardPhoto=" + idCardPhoto + ", ekycConsent=" + ekycConsent
				+ "]";
	}

}
