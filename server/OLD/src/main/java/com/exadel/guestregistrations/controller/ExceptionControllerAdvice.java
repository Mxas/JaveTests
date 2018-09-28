package com.exadel.guestregistrations.controller;

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mongodb.MongoWriteException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	private static Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);
	
	private MessageSource messageSource;
	
	public ExceptionControllerAdvice(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = MessageController.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
		
		if(localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
			String[] fieldErrorCodes = fieldError.getCodes();
			localizedErrorMessage = fieldErrorCodes[0];
		}
		
		return localizedErrorMessage;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ModelMap validationExceptionHandler(MethodArgumentNotValidException e) {
		logger.error(messageSource.getMessage("Logger.Validation.Errors", null, MessageController.getLocale()));
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		ModelMap errors = new ModelMap();
		for(FieldError fieldError : fieldErrors) {
			errors.addAttribute(fieldError.getField(), resolveLocalizedErrorMessage(fieldError));
			logger.error(fieldError.getField() + ": " + resolveLocalizedErrorMessage(fieldError));
		}
		return errors;
	}
	
	@ExceptionHandler(MongoWriteException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ModelMap uniqueIndexExceptionHandler() {
		logger.error(messageSource.getMessage("Logger.Validation.Errors", null, MessageController.getLocale()));
		logger.error("cardNumber: " + messageSource.getMessage("Validation.Card.AlreadyExists", null, MessageController.getLocale()));
		ModelMap error = new ModelMap();
		error.addAttribute("cardNumber", messageSource.getMessage("Validation.Card.AlreadyExists", null, MessageController.getLocale()));
		return error;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ModelMap notReadableExceptionHandler() {
		logger.error(messageSource.getMessage("Logger.Validation.Errors", null, MessageController.getLocale()));
		logger.error("cardNumber: " + messageSource.getMessage("Validation.Card.MustBeANumber", null, MessageController.getLocale()));
		ModelMap error = new ModelMap();
		error.addAttribute("cardNumber", messageSource.getMessage("Validation.Card.MustBeANumber", null, MessageController.getLocale()));
		return error;
	}
}
