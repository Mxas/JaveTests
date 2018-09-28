package com.exadel.guestregistrations.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exadel.guestregistrations.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

	Long countByUsername(String username);

}