package com.exadel.guestregistrations.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.repository.CardRepository;

@Component
public class CardValidator implements Validator{
	
	@Autowired
	CardRepository cardRepository;

	@Override
	public boolean supports(Class<?> cl) {
		return cl == Card.class;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Card cardTarget = (Card) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "validFrom", "Validation.EmptyField");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "validTo", "Validation.EmptyField");
		
		if(!errors.hasFieldErrors("cardNumber")) {
			if(cardTarget.getCardNumber() == 0) errors.rejectValue("cardNumber", "Validation.EmptyField");
			if(cardTarget.getCardNumber() < 0) errors.rejectValue("cardNumber", "Validation.Card.CardNumber");
		}
		
		if(!errors.hasFieldErrors("validFrom") && !errors.hasFieldErrors("validTo")) {
			if(!cardTarget.getValidFrom().before(cardTarget.getValidTo())) {
				errors.rejectValue("validTo", "Validation.Card.DateRange");
			}
		}
	}
}
