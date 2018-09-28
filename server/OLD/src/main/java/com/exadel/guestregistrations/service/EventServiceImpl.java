package com.exadel.guestregistrations.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exadel.guestregistrations.model.Event;
import com.exadel.guestregistrations.model.GuestAgent;
import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.repository.EventRepository;
import com.exadel.guestregistrations.repository.GuestRepository;
import com.exadel.guestregistrations.repository.AgentRepository;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private EventRepository eventRepository;


	@Override
	public List<Event> findAllEvents() {

		return eventRepository.findAll();
	}

	@Override
	public Event findById(String id) {

		Optional<Event> result = eventRepository.findById(id);

		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteEvent(String id) {
		eventRepository.deleteById(id);

	}

	@Override
	public void addEvent(Event event) {
		eventRepository.save(event);

	}

	@Override
	public void update(Event event) {
		eventRepository.save(event);

	}

	@Override
	public List<Agent> findInvitationsByEventId(String id) {
		List<Agent> listOfInvited = new ArrayList<>();
		Event event = findById(id);

		List<String> list = event.getInvitedList();
		if (list == null) {
			return Collections.emptyList();
		} else {
			for (String s : list) {
				Optional<Agent> result = agentRepository.findById(s);
				if (result.isPresent()) {
					listOfInvited.add(result.get());
				}
			}
		}
		return listOfInvited;
	}

	@Override
	public void addGuestToArrived(GuestAgent guestAgent) {
		Agent guestArrived = agentRepository.findByEmail(guestAgent.getEmail()).get(0);

		Event event = eventRepository.findByDescription(guestAgent.getArrivalPurpose()).get(0);

		if (event.getArrivedList() != null) {
			event.getArrivedList().add(guestArrived.getId());

		}

		else {
			List<String> listOfArrived = new ArrayList<>();
			listOfArrived.add(guestArrived.getId());
			event.setArrivedList(listOfArrived);

		}
		eventRepository.save(event);
	}

}
