package com.exadel.guestregistrations.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.service.AgentService;


@RestController
@RequestMapping("/api/agents")

@CrossOrigin(origins = "http://localhost:3000")
public class AgentController {


	@Autowired
	private AgentService agentService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Agent> findAllContacts()  {
				
		return agentService.findAllAgents();
	}	
}