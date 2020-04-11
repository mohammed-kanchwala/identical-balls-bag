package com.bayzat.service.impl;

import com.bayzat.exception.ApiException;
import com.bayzat.model.BagsResponse;
import com.bayzat.service.BagService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Bags Service Tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BagsServiceImplTests {

	@InjectMocks
	private BagService bagService = new BagServiceImpl();

	@Test
	@DisplayName("Calculate Total Numbers for 3 Balls")
	public void calculateTotalNumbers_For3Balls() throws ApiException {
		BagsResponse response = bagService.calculateTotalNumbers(3);
		assertEquals(response.getTotalNoOfWays(), 3);
	}

	@Test
	@DisplayName("Calculate Total Numbers for 5 Balls")
	public void calculateTotalNumbers_For5Balls() throws ApiException {
		BagsResponse response = bagService.calculateTotalNumbers(5);
		assertEquals(response.getTotalNoOfWays(), 8);
	}
}
