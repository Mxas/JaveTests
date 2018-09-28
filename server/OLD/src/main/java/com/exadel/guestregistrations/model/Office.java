package com.exadel.guestregistrations.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.ui.ModelMap;

@Document (collection = "offices")
public class Office {

	@Id	
	private String id;	
	private String adress;
	private List<ModelMap> users;

	public Office(String id, String adress, List<ModelMap> users) {
		this.id = id;
		this.adress = adress;
		this.users = users;
	}

	public Office() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public List<ModelMap> getUsers() {
		return users;
	}

	public void setUsers(List<ModelMap> users) {
		this.users = users;
	}

}
