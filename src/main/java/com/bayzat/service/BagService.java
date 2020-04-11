package com.bayzat.service;

import com.bayzat.exception.ApiException;
import com.bayzat.model.BagsResponse;

public interface BagService {
	/**
	 * Calculates total number of ways to remove balls from a bag
	 *
	 * @param balls total number of balls present in the bag
	 * @return total number of ways the balls can be removed from the bag
	 * @throws ApiException thrown when error occurs in processing
	 */
	BagsResponse calculateTotalNumbers(Integer balls) throws ApiException;
}
