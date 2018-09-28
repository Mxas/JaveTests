package com.exadel.guestregistrations.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.Guest;
import com.exadel.guestregistrations.model.GuestAgent;
import com.exadel.guestregistrations.model.User;
import com.exadel.guestregistrations.service.AgentService;
import com.exadel.guestregistrations.service.EventService;
import com.exadel.guestregistrations.service.GuestService;
import com.exadel.guestregistrations.service.UsernameAlreadyExistsException;

@RestController
@RequestMapping("/api/guests")

@CrossOrigin(origins = "http://localhost:3000")
public class GuestController {

	@Autowired
	private GuestService guestService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private EventService eventService;

	@RequestMapping(method = RequestMethod.GET)
	public List<GuestAgent> findAllGuests() {
		List<Guest> guests = guestService.findAllGuests();
		List<GuestAgent> guestAgents = new ArrayList<>();

		guests.forEach((guest) -> {
			guestAgents.add(new GuestAgent(guest, agentService.findById(guest.getAgentId())));
		});

		return guestAgents;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addGuest")
	public String save(@RequestBody GuestAgent guestAgent) {

		agentService.addAgent(guestAgent);

		guestService.addGuest(guestAgent);
		
		if (!guestAgent.getArrivalPurpose().equals("Other")) {
			eventService.addGuestToArrived(guestAgent);
		}
		return guestAgent.getId();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(@RequestBody GuestAgent guestAgent) {
		guestService.update(guestAgent);
		return guestAgent.getId();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public GuestAgent getGuest(@PathVariable final String id) {
		Guest guest = guestService.findById(id);
		Agent agent = agentService.findById(guest.getAgentId());

		return new GuestAgent(guest, agent);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String delete(@PathVariable String id) {
		GuestAgent guestAgent = getGuest(id);

		agentService.deleteAgent(guestAgent.getAgentId());
		guestService.deleteGuest(id);

		return "guest deleted";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteGuestByEmail")
	public String deleteByEmail(String email) {
		Guest guest = guestService.findByEmail(email);
		
		if(guest != null) {
			agentService.deleteAgent(guest.getAgentId());
			guestService.deleteGuest(guest.getId());

			return "Registration ended successfully";
		}
		
		return "No guest found with the email address " + email;
	}
}