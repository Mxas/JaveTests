package com.exadel.guestregistrations.mvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.exadel.guestregistrations.controller.AuthController;
import com.exadel.guestregistrations.controller.CardController;
import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.payload.JwtAuthenticationResponse;
import com.exadel.guestregistrations.payload.LoginRequest;


// https://spring.io/guides/gs/testing-web/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardControllerTest_FullRestsFlow {

    private final static String REQUEST_MAPPING = "api/cards";

    @LocalServerPort
    private int port;

    @Autowired
    private CardController controller;

    @Autowired
    private AuthController authController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void before() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("admin");
        loginRequest.setUsername("admin");
        ResponseEntity<JwtAuthenticationResponse> t = authController.authenticateUser(loginRequest);

        restTemplate.getRestTemplate().setInterceptors(
                Collections.singletonList((request, body, execution) -> {
                    request.getHeaders()
                            .add("Authorization", t.getBody().getTokenType() + " " + t.getBody().getAccessToken());
                    return execution.execute(request, body);
                }));
    }




    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(authController).isNotNull();
    }


    @Test
    public void test_findAllCards() throws Exception {
        assertThat(this.restTemplate.getForObject(link(), ArrayList.class)).hasSize(0);
    }

    @Test
    public void test_addCard() throws Exception {
        Card card = new Card();
        card.setCardNumber(11);
//        card.setValidFrom("2000-01-01");
//        card.setValidTo("2020-01-01");
        ResponseEntity<String> entity = this.restTemplate.postForEntity(link() + "/addCard", card, String.class);
        assertThat(entity.getBody()).isNotBlank();

        assertThat(this.restTemplate.getForObject(link(), ArrayList.class)).hasSize(1);
    }



    private String link() {
        return "http://localhost:" + port + "/" + REQUEST_MAPPING;
    }

}
