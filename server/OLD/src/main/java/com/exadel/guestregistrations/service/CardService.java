package com.exadel.guestregistrations.service;


import java.util.List;

import com.exadel.guestregistrations.model.Card;

public interface CardService {

	List<Card> findAllCards();
	
	Card findById(String id);
	
	void addCard(Card card);
	
	void deleteCard(String id);

	List<Card> findEmptyCardsforGuest();

	List<Card> findEmptyCardsforAdmin();
}
