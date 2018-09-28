package com.exadel.guestregistrations.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.GuestAgent;
import com.exadel.guestregistrations.model.UserAgent;
import com.exadel.guestregistrations.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	AgentRepository agentRepository;

	@Override
	public List<Agent> findAllAgents() {
		return agentRepository.findAll();
	}

	@Override
	public Agent findById(String id) {
		return agentRepository.findById(id).get();
	}

	@Override
	public void deleteAgent(String id) {
		agentRepository.deleteById(id);
	}

	@Override
	public void addAgent(GuestAgent guestAgent) {
		Agent agent = new Agent(guestAgent.getName(), guestAgent.getSurname(), guestAgent.getEmail(),
				guestAgent.getPhoneNo(), guestAgent.getPhoto());
		List<Agent> existingAgent = agentRepository.findByEmail(guestAgent.getEmail());
		if (existingAgent.isEmpty()) {
			agentRepository.save(agent);
		}
	}

	@Override
	public void update(Agent agent) {
		agentRepository.save(agent);
	}

	@Override
	public void addUserAgent(UserAgent userAgent) {
		Agent agent = new Agent(userAgent.getName(), userAgent.getSurname(), null, null, null);
		agentRepository.save(agent);
	}
}
