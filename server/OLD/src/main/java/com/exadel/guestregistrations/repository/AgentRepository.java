package com.exadel.guestregistrations.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.exadel.guestregistrations.model.Agent;


public interface AgentRepository extends MongoRepository<Agent, String> {
	List<Agent> findByEmail (String email);
}
