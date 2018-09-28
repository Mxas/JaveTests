package com.exadel.guestregistrations.model;

import java.util.Date;

public class GuestAgent {
	private String id;	
	private String officeId;
    private String guestType;  
    private Date arrivalDate;   
    private Date leavingDate;
    private String arrivalPurpose;
    private String photo;
    private String signature;
    private int cardNumber;
    
    private String agentId;
    private String name;
	private String surname;
	private String email;
	private String phoneNo;
	
	public GuestAgent() {}
	
	public GuestAgent(Guest guest, Agent agent) {
		this.id = guest.getId();
		this.officeId = guest.getOfficeId();
		this.guestType = guest.getGuestType();
		this.arrivalDate = guest.getArrivalDate();
		this.leavingDate = guest.getLeavingDate();
		this.arrivalPurpose = guest.getArrivalPurpose();
		this.photo = guest.getPhoto();
		this.signature = guest.getSignature();
		this.cardNumber = guest.getCardNumber();
		
		this.agentId = agent.getId();
		this.name = agent.getName();
		this.surname = agent.getSurname();
		this.email = agent.getEmail();
		this.phoneNo = agent.getPhoneNo();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOfficeId() {
		return officeId;
	}
	
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	public String getGuestType() {
		return guestType;
	}
	
	public void setGuestType(String guestType) {
		this.guestType = guestType;
	}
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public Date getLeavingDate() {
		return leavingDate;
	}
	
	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}
	
	public String getArrivalPurpose() {
		return arrivalPurpose;
	}
	
	public void setArrivalPurpose(String arrivalPurpose) {
		this.arrivalPurpose = arrivalPurpose;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getSignature() {
		return signature;
	}
	
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getAgentId() {
		return agentId;
	}
	
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
