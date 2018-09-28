package com.exadel.guestregistrations.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.exadel.guestregistrations.model.Office;

@Component
public class OfficeValidator implements Validator{

	@Override
	public boolean supports(Class<?> cl) {
		return cl == Office.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Office officeTarget = (Office) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adress", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "users", "Validation.EmptyField");
		
		if(!errors.hasFieldErrors("users")) {
			if(officeTarget.getUsers() == null || officeTarget.getUsers().size() == 0) errors.rejectValue("users", "Validation.EmptyField");
		}
	}

}
