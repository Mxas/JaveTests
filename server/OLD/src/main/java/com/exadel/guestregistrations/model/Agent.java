package com.exadel.guestregistrations.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="agents")
public class Agent {
	@Id
	private String id;
	private String name;
	private String surname;
	private String email;
	private String phoneNo;
	private String photo;
	
	public Agent() {}
	
	public Agent(String name, String surname, String email, String phoneNo, String photo) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.photo = photo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}