package com.exadel.guestregistrations.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.exadel.guestregistrations.model.Guest;

public interface GuestRepository extends MongoRepository<Guest, String> {
	@Query(value = "{'email' : ?0}")
	Guest findByEmail(String email);
}