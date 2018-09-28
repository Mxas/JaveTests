package com.exadel.guestregistrations.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exadel.guestregistrations.model.Office;
import com.exadel.guestregistrations.repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService {
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Override
	public List<Office> findAllOffices() {

		return officeRepository.findAll();
	}

	@Override
	public Office findById(String id) {
		
		Optional<Office> result = officeRepository.findById(id);

		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteOffice(String id) {
		officeRepository.deleteById(id);
		
	}

	@Override
	public void addOffice(Office office) {
		officeRepository.save(office);
		
	}
	
}
