package com.exadel.guestregistrations.service;

import java.util.List;

import com.exadel.guestregistrations.model.User;

public interface UserService {
	List<User> findAllUsers();

	User findById(String id);

	void deleteUser(String id);

	void addUser(User user) throws UsernameAlreadyExistsException;
	
	void editUser(User user);
}
