package com.crif.cff.brk.hsbcb.routes.otp.model;

public class OtpRequest {

	private String name;
	private String ektp;
	private String email;
	private String countryCode;
	private String phoneNumber;
	private String cardType;
	private String giftID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEktp() {
		return ektp;
	}
	public void setEktp(String ektp) {
		this.ektp = ektp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getGiftID() {
		return giftID;
	}
	public void setGiftID(String giftID) {
		this.giftID = giftID;
	}
	public String getPhoneNumberWithCountryCode() {
		return this.countryCode+this.phoneNumber;
	}
	
}
