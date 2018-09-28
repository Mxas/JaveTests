package com.exadel.guestregistrations;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.fail;


import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import com.exadel.guestregistrations.contexts.RepositoriesContextConfig;
import com.exadel.guestregistrations.contexts.ServicesContextConfig;
import com.exadel.guestregistrations.model.User;
import com.exadel.guestregistrations.repository.UserRepository;
import com.exadel.guestregistrations.service.UserServiceImpl;
import com.exadel.guestregistrations.service.UsernameAlreadyExistsException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;





@EnableAutoConfiguration
@ContextConfiguration(classes = {RepositoriesContextConfig.class, ServicesContextConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class UserTest {

	// private static Validator validator;
	private User user1;
	private User user2;
	private User user3;
	private String IdNum;

	

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserServiceImpl userService;

	@Before
	public void setUp() throws Exception {
		// ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		// validator = factory.getValidator();

		user1 = new User();
		user2 = new User();
		user3 = new User();

	}

	@Test
	public void testSaveAndFindById() throws UsernameAlreadyExistsException {
//		user1.setName("testname1");
//		user1.setSurname("testsurname1");
		user1.setOfficeId("officeid1");
		user1.setActivation("active");
		user1.setPassword("password1");
		user1.setUsername("username1");
		user1.setId("identityNum");
		userService.addUser(user1);

		User userA = userService.findById("identityNum");
		assertNotNull(userA);

//		user2.setName("testname1");
//		user2.setSurname("testsurname1");
		user2.setOfficeId("officeid1");
		user2.setActivation("active");
		user2.setPassword("password1");
		user2.setUsername("username1");
		try {
			userService.addUser(user1);
			fail("Expected UsernameAlreadyExistException to be thrown");
		} catch (UsernameAlreadyExistsException e) {

		}

	}

	/*
	 * @Test public void testFormFilled() {
	 * 
	 * User user1 = new User(); user1.setName("testname1");
	 * 
	 * Set<ConstraintViolation<User>> violations = validator.validate(user1);
	 * assertFalse(violations.isEmpty()); assertEquals(5, violations.size()); }
	 */

	

	@Test
	public void testUpdate() throws UsernameAlreadyExistsException {
		user1.setOfficeId("123");
		user1.setPassword("password");
		user1.setActivation("deactivated");
//		user1.setName("testname");
//		user1.setSurname("testsurname");

		userService.editUser(user1);
		User userA = userService.findById(user1.getId());

		assertEquals("123", userA.getOfficeId());
		assertEquals("password", userA.getPassword());
		assertEquals("deactivated", userA.getActivation());
//		assertEquals("testname", userA.getName());
//		assertEquals("testsurname", userA.getSurname());

	}

	@Test
	public void testDelete() {

		user3.setOfficeId("1235666");
		user3.setPassword("password664");
		user3.setActivation("deactivated");
//		user3.setName("testname1277");
//		user3.setSurname("testsurname4534");
		user3.setUsername("testusername56677");
		userRepository.save(user3);
		assertNotNull(user3.getId());
		IdNum = user3.getId();

		userService.deleteUser(IdNum);

		try {
			userService.findById(IdNum);
			fail("Expected NoSuchElementException to be thrown");
		} catch (NoSuchElementException e) {

		}

	}

	@Before
	@After
	public void afterEachCase() {
		userRepository.deleteAll();
	}

}
