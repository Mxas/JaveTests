package com.exadel.guestregistrations.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public List<Card> findAllCards() {

		return cardRepository.findAll();
	}

	@Override
	public Card findById(String id) {

		return cardRepository.findById(id).get();
	}

	@Override
	public void addCard(Card card) {

		cardRepository.save(card);
	}

	@Override
	public void deleteCard(String id) {
		cardRepository.deleteById(id);

	}

	@Override
	public List<Card> findEmptyCardsforGuest() {
		List<Card> cards = cardRepository.findByholderName("");
		if (cards.isEmpty())
			return null;
		else {
			return cards;
		}

	}

	@Override
	public List<Card> findEmptyCardsforAdmin() {
			return cardRepository.findByholderName("");
	}

}
