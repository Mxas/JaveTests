package com.exadel.guestregistrations.service;

import java.util.List;

import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.Event;
import com.exadel.guestregistrations.model.GuestAgent;

public interface EventService {

	List<Event> findAllEvents();

	Event findById(String id);

	void deleteEvent(String id);

	void addEvent(Event event);

	void update(Event event);

	List<Agent> findInvitationsByEventId(String id);

	void addGuestToArrived(GuestAgent guestAgent);
}
