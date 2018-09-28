package com.exadel.guestregistrations.service;

import java.util.List;
import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.GuestAgent;
import com.exadel.guestregistrations.model.UserAgent;

public interface AgentService {
	List<Agent> findAllAgents();
	
	Agent findById(String id);
	
	void deleteAgent(String id);

	void addAgent(GuestAgent guestAgent);

	void update(Agent agent);

	void addUserAgent(UserAgent userAgent);
}
