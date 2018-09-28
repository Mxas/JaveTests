package com.exadel.guestregistrations.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.exadel.guestregistrations.model.Event;
import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.service.EventService;


@RestController
@RequestMapping("/api/events")

@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
	
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Event> findAllEvents() {
		return eventService.findAllEvents();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addEvent")
	public String save(@RequestBody Event event) {
		eventService.addEvent(event);

		return event.getId();
	}

	@RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Event event) {
        eventService.update(event);
		return event.getId();
    }
	

	@RequestMapping(method = RequestMethod.GET, value = "/findEvent/{id}")
	public Event getEvent(@PathVariable final String id) {
		return eventService.findById(id);
	}  
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public List<Agent> getEventParticipants(@PathVariable final String id) {

		return eventService.findInvitationsByEventId(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String delete(@PathVariable String id) {
		eventService.deleteEvent(id);
		return "event deleted";
	} 
}
