package com.bayzat.service;

import com.bayzat.BagsResponse;
import com.bayzat.exception.ApiException;

public interface BagService {
    BagsResponse calculateTotalNumbers (Integer balls) throws ApiException;
}
