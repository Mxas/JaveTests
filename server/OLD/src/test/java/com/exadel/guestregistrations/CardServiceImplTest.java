package com.exadel.guestregistrations;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exadel.guestregistrations.contexts.RepositoriesContextConfig;
import com.exadel.guestregistrations.contexts.ServicesContextConfig;
import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.repository.CardRepository;
import com.exadel.guestregistrations.service.CardService;

@EnableAutoConfiguration
@ContextConfiguration(classes = {RepositoriesContextConfig.class, ServicesContextConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DataMongoTest
public class CardServiceImplTest {

    private static final int CARD_NUMBER = 123;
    private static final String HOLDER_NAME = "Name 123";
    private static final String HOLDER_SURNAME = "S123";
    private static final String VALID_FROM = "2000-01-01";
    private static final String VALID_TO = "2020-02-02";

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;

    @After
    @Before
    public void afterEachCase() {
        cardRepository.deleteAll();
    }

    @Test
    public void test_AddCard() {

        Card card = createDummy();
        cardService.addCard(card);

        Assert.assertEquals(1, cardService.findAllCards().size());
    }

    @Test
    public void test_findById() {
        Card card = createDummy();
        cardService.addCard(card);
        String id = card.getId();

        Card loaded = cardService.findById(id);

        assertNotNull(card);

        assertEquals(CARD_NUMBER, loaded.getCardNumber());
        //....

    }

    //.... other tests

    private Card createDummy() {
        Card card = new Card();
        card.setCardNumber(CARD_NUMBER);
        card.setHolderName(HOLDER_NAME);
        card.setHolderSurname(HOLDER_SURNAME);
//        card.setValidFrom(VALID_FROM);
//        card.setValidTo(VALID_TO);

        return card;
    }


}
