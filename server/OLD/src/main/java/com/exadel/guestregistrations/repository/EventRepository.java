package com.exadel.guestregistrations.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.exadel.guestregistrations.model.Event;

public interface EventRepository extends MongoRepository<Event, String>{
	List<Event> findByDescription (String description);
}
