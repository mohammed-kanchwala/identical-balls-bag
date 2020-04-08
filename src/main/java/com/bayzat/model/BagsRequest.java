package com.bayzat.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class BagsRequest {

    @NotNull
    @Min(value = 1, message = "The number of balls should be minimum 1")
    @Max(value = 10, message = "The number of balls is limited to max 10")
    private Integer balls;
}
