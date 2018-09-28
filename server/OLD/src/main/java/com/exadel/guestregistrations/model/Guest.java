package com.exadel.guestregistrations.model;

import java.util.Date;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.BasicDBObject;

@Document(collection = "guests")
public class Guest {
	@Id    
	private String id;	
	private String officeId;
	private String agentId;
    private String guestType;  
    private Date arrivalDate;   
    private Date leavingDate;
    private String arrivalPurpose;
    private String photo;
    private String signature;
    private int cardNumber;
    
    public Guest() {}
    
    public Guest(String officeId, String agentId, String guestType, Date arrivalDate, Date leavingDate, String arrivalPurpose, String photo, String signature, int cardNumber) {
    	this.officeId = officeId;
    	this.agentId = agentId;
    	this.guestType = guestType;
    	this.arrivalDate = arrivalDate;
    	this.leavingDate = leavingDate;
    	this.arrivalPurpose = arrivalPurpose;
    	this.photo = photo;
    	this.signature = signature;
    	this.cardNumber = cardNumber;
    }
    
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	
	
	public String getAgentId() {
		return agentId;
	}
	
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
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
	
	public void setArrivalPurpose(String purposeOfArrival) {
		this.arrivalPurpose = purposeOfArrival;
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

	public void setPhoto(Binary binary) {
		
		
	}

	public void setPhoto(byte[] b) {
		
		
	}

	public void setPhoto(BasicDBObject photo1) {
		
		
	}
}
