package com.exadel.guestregistrations.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.exadel.guestregistrations.model.Office;

public interface OfficeRepository extends MongoRepository<Office, String> {

}
