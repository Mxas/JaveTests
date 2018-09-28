package com.exadel.guestregistrations.service;

import java.util.List;

import com.exadel.guestregistrations.model.Guest;
import com.exadel.guestregistrations.model.GuestAgent;

public interface GuestService {
	
	List<Guest> findAllGuests();
	
	Guest findById(String id);
	
	Guest findByEmail(String email);

	void deleteGuest(String id);

	void addGuest(GuestAgent guestAgent);

	void update(GuestAgent guestAgent);
}
