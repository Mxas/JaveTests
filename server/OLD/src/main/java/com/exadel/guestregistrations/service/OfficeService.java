package com.exadel.guestregistrations.service;

import java.util.List;

import com.exadel.guestregistrations.model.Office;


public interface OfficeService {
	
	List<Office> findAllOffices();
	
	Office findById(String id);

	void deleteOffice(String id);

	void addOffice(Office office);
	
}