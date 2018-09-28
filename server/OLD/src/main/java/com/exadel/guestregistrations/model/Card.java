package com.exadel.guestregistrations.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class Card {
	@Id
	private String id;
	@Indexed(unique=true)
	private int cardNumber;
	private String holderName;
	private String holderSurname;
	private Date validFrom;
	private Date validTo;
	
	
	public Card() {}

	public Card(String id, int cardNumber, String holderName, String holderSurname, Date validFrom, Date validTo) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.holderName = holderName;
		this.holderSurname = holderSurname;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getHolderSurname() {
		return holderSurname;
	}

	public void setHolderSurname(String holderSurname) {
		this.holderSurname = holderSurname;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFromTs(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidToTs(Date validTo) {
		this.validTo = validTo;
	}

}
