package com.exadel.guestregistrations.model;

public class UserAgent {
private String id;
	private String officeId;
	private String agentId;
	private String activation;
	private String username;	
	private String password;
	
	private String name;
	private String surname;
	
	public UserAgent() {}
	
	public UserAgent(User user, Agent agent) {
		this.id = user.getId();
		this.officeId = user.getOfficeId();
		this.agentId = user.getAgentId();
		this.activation = user.getActivation();
		this.username = user.getUsername();
		this.password = user.getPassword();
		
		this.name = agent.getName();
		this.surname = agent.getSurname();
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
}
