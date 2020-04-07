package com.bayzat.controller;

import com.bayzat.BagsResponse;
import com.bayzat.exception.ApiException;
import com.bayzat.service.BagService;
import com.bayzat.utility.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class BagsController {

    @Autowired
    private BagService bagService;

    @GetMapping(ApiConstants.CALCULATE)
    public ResponseEntity<BagsResponse> searchInsurance(@RequestParam Integer balls)
            throws ApiException {
        return ok(bagService.calculateTotalNumbers(balls));
    }
}
