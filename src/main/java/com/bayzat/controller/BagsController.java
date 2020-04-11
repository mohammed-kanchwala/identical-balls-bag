package com.bayzat.controller;

import com.bayzat.exception.ApiException;
import com.bayzat.model.BagsRequest;
import com.bayzat.model.BagsResponse;
import com.bayzat.service.BagService;
import com.bayzat.utility.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class BagsController {

	@Autowired
	private BagService bagService;

	@Value("${spring.application.name}")
	private String appName;

	/**
	 * Test the application running status by hitting the root url and fetching
	 * the name of the application from the properties.
	 *
	 * @return Application name
	 */
	@GetMapping("/")
	public ResponseEntity<String> getApplicationName() {
		return ok("Welcome to " + appName);
	}


	/**
	 * Calculates the total number of ways to fetch balls from the bag based on
	 * the input no of balls
	 *
	 * @param bagsRequest Contains total number of balls in the bag
	 * @return Total Number of ways the balls can be removed from the bag
	 * @throws ApiException thrown when an error occurs in the processing the
	 *                      request
	 */
	@PostMapping(ApiConstants.CALCULATE)
	public ResponseEntity<BagsResponse> calculateTotalNumbers(@Valid @RequestBody BagsRequest bagsRequest)
			throws ApiException {
		return ok(bagService.calculateTotalNumbers(bagsRequest.getBalls()));
	}
}
