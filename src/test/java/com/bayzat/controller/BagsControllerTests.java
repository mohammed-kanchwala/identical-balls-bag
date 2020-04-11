package com.bayzat.controller;

import com.bayzat.model.BagsRequest;
import com.bayzat.model.BagsResponse;
import com.bayzat.utility.ApiConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BagsControllerTests {

	private static String baseUrl;
	private final String url = "http://localhost:";
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void createURL() {
		baseUrl = url + port;
	}

	@Test
	@DisplayName("Root URL Test")
	public void greetingShouldReturnDefaultMessage() {
		assertThat(this.restTemplate.getForObject(
				baseUrl, String.class))
				.contains("Welcome to Identical Balls Bag Application");
	}

	@Test
	@DisplayName("Test to check the total Number of Ways for Bag with 3 Balls")
	public void calculateNumbers_For3Balls() {
		BagsRequest request = new BagsRequest();
		request.setBalls(3);
		BagsResponse response = restTemplate.postForObject(
				baseUrl + ApiConstants.CALCULATE, request, BagsResponse.class);
		assertEquals(response.getTotalNoOfWays(), 3);
	}

	@Test
	@DisplayName("Test to check the total Number of Ways for Bag with 5 Balls")
	public void calculateNumbers_For5Balls() {
		BagsRequest request = new BagsRequest();
		request.setBalls(5);
		BagsResponse response = restTemplate.postForObject(
				baseUrl + ApiConstants.CALCULATE, request, BagsResponse.class);
		assertEquals(response.getTotalNoOfWays(), 8);
	}

	@Test
	@DisplayName("Test to check the total Number of Ways for Bag with 0 Balls")
	public void calculateNumbers_For0Balls() {
		BagsRequest request = new BagsRequest();
		request.setBalls(0);
		BagsResponse response = restTemplate.postForObject(
				baseUrl + ApiConstants.CALCULATE, request, BagsResponse.class);
		assertNull(response.getTotalNoOfWays());
	}

	@Test
	@DisplayName("Test to check the total Number of Ways for Bag with 0 Balls")
	public void calculateNumbers_ForMoreThan10Balls() {
		BagsRequest request = new BagsRequest();
		request.setBalls(20);
		BagsResponse response = restTemplate.postForObject(
				baseUrl + ApiConstants.CALCULATE, request, BagsResponse.class);
		assertNull(response.getTotalNoOfWays());
	}
}
