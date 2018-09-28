package com.exadel.guestregistrations.mvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.exadel.guestregistrations.controller.AuthController;
import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.payload.JwtAuthenticationResponse;
import com.exadel.guestregistrations.payload.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

// https://spring.io/guides/gs/testing-web/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DataMongoTest
public class CardControllerTest_MockMvc {

    private final static String REQUEST_MAPPING = "/api/cards";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthController authController;

    ResponseEntity<JwtAuthenticationResponse> token;

    @Before
    public void before() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("admin");
        loginRequest.setUsername("admin");
        token = authController.authenticateUser(loginRequest);

    }


    @Test
    public void test_findAllCards() throws Exception {

        this.mockMvc.perform(header(get(REQUEST_MAPPING))).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("[*]", hasSize(0)));


    }


    @Test
    public void test_addCard() throws Exception {
        Card card = new Card();
        card.setCardNumber(11);
//        card.setValidFrom("2000-01-01");
//        card.setValidTo("2020-01-01");

        this.mockMvc.perform(
                header(post(REQUEST_MAPPING + "/addCard")
                        .content(asJsonString(card))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
        )
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(header(get(REQUEST_MAPPING))).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("[*]", hasSize(1)));
    }

    private RequestBuilder header(MockHttpServletRequestBuilder get) {
        return get.header("Authorization", token.getBody().getTokenType() + " " + token.getBody().getAccessToken());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
