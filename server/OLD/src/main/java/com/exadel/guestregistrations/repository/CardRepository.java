package com.exadel.guestregistrations.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.exadel.guestregistrations.model.Card;


public interface CardRepository extends MongoRepository<Card, String>{
	List<Card> findByholderName (String holderName);
	List<Card> findByCardNumber (int cardNumber);

}
