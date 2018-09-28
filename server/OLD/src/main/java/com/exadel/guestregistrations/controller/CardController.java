package com.exadel.guestregistrations.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.service.CardService;
import com.exadel.guestregistrations.validator.CardValidator;



@RestController
@RequestMapping("api/cards")

@CrossOrigin(origins = "http://localhost:3000")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CardValidator cardValidator;
	
	private static Logger logger = LogManager.getLogger(CardController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if(target == null) {
			return;
		}
		
		if(target.getClass() == Card.class) {
			dataBinder.setValidator(cardValidator);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Card> findAllCards(){
		return cardService.findAllCards();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addCard")
	public String save(@RequestBody @Validated Card card) {
		cardService.addCard(card);
		logger.info("Card number " + card.getCardNumber() + " added successfully.");
		return card.getId();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Card getCard(@PathVariable final String id) {
		return cardService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/emptyCardsSelfRegistration")
	public List<Card> findEmptyCardsforGuest(){
		return cardService.findEmptyCardsforGuest();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/emptyCardsAdminRegistration")
	public List<Card> findEmptyCardsforAdmin(){
		return cardService.findEmptyCardsforAdmin();
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public Card updateCard(@PathVariable final String id, @RequestBody @Validated Card card) {
		Card c = cardService.findById(id);
		
		cardService.addCard(card);
		logger.info("Card number " + card.getCardNumber() + " edited successfully.");
		
		return c;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public String deleteCard(@PathVariable String id) {
		logger.info("Card number " + cardService.findById(id).getCardNumber() + " deleted successfully.");
		cardService.deleteCard(id);
		return "card deleted";
	}
}
