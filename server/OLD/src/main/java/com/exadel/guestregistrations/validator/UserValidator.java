package com.exadel.guestregistrations.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.exadel.guestregistrations.model.UserAgent;
import com.exadel.guestregistrations.repository.UserRepository;

@Component 
public class UserValidator implements Validator {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> cl) {
		return cl == UserAgent.class;
	}

	public void validate(Object target, Errors errors) {
		UserAgent userTarget = (UserAgent) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeId", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activation", "Validation.EmptyField");
		
		if(!errors.hasFieldErrors("password")) {
			if(userTarget.getPassword().length() < 5) {
				errors.rejectValue("password", "Validation.User.PasswordTooShort");
			}
		}
	
	}
}