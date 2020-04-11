package com.bayzat.service.impl;

import com.bayzat.exception.ApiException;
import com.bayzat.model.BagsResponse;
import com.bayzat.service.BagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BagServiceImpl implements BagService {
	@Override
	public BagsResponse calculateTotalNumbers(Integer balls) throws ApiException {
		try {
			log.debug("Number of Balls in a Bag: " + balls);
			Integer totalNoOfWays = calculate(balls);
			log.debug("Total Number of ways to remove balls from the : " + totalNoOfWays);
			BagsResponse response = new BagsResponse();
			response.setTotalNoOfWays(totalNoOfWays);
			return response;
		} catch (Exception e) {
			throw new ApiException("Exception in Processing the calculation");
		}
	}

	private Integer calculate(int balls) {
		switch (balls) {
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 2;
			default:
				return calculate(balls - 1) + calculate(balls - 2);
		}
	}
}
