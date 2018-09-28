package com.exadel.guestregistrations.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")

public class User {
	@Id
	private String id;
	
	@NotEmpty
	private String officeId;
	
	@NotEmpty
	private String activation;
	
	@NotEmpty
	private String username;	

	@NotEmpty
	private String password;
	
	private String agentId;
	
	@NotEmpty
	private Set<Role> role = new HashSet<>();
	
	public User() {}
	
	public User(String officeId, String agentId, String username, String password, String activation) {
		this.officeId = officeId;
		this.agentId = agentId;
		this.username = username;
		this.password = password;
		this.activation = activation;
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
	
	public String getAgentId() {
		return agentId;
	}
	
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRole() {
		return role;
	}
	
	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
