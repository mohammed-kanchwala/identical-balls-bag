package com.bayzat.controller;

import com.bayzat.BagsResponse;
import com.bayzat.exception.ApiException;
import com.bayzat.model.BallsRequest;
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

    @GetMapping("/")
    public ResponseEntity<String> getApplicationName() {
        return ok("Welcome to " + appName);
    }


    @PostMapping(ApiConstants.CALCULATE)
    public ResponseEntity<BagsResponse> calculateTotalNumbers(@Valid @RequestBody BallsRequest ballsRequest)
            throws ApiException {
        return ok(bagService.calculateTotalNumbers(ballsRequest.getBalls()));
    }
}
