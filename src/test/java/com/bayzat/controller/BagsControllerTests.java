package com.bayzat.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = BagsController.class)
public class BagsControllerTests {

//    @Autowired
//    private MockMvc mockMvc;

    private final String url = "http://localhost:";
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Root URL Test")
    public void greetingShouldReturnDefaultMessage() {
        assertThat(this.restTemplate.getForObject(
                url + port, String.class))
                .contains("Welcome to Identical Balls Bag Application");
    }
}
