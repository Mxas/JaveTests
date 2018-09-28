package com.exadel.guestregistrations.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.exadel.guestregistrations.model.User;
import com.exadel.guestregistrations.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User findById(String id) {

		Optional<User> result = userRepository.findById(id);

		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(String id) {

		userRepository.deleteById(id);

	}

	@Override
	public void addUser(User user) throws UsernameAlreadyExistsException {

		Long countOfDuplicates = userRepository.countByUsername(user.getUsername());
		if (countOfDuplicates == 1)
			throw new UsernameAlreadyExistsException("Username should be unique");

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepository.save(user);

	}

	@Override
	public void editUser(User user) {

		userRepository.save(user);

	}

}
