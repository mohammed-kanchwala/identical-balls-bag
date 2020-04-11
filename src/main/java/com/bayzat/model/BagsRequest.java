package com.bayzat.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class BagsRequest {

    /**
     * The number of balls cannot be null and the minimum is set to 1 so that
     * the bag needs at least 1 ball to be removed.
     * The maximum is set to 10 to limit the processing time and avoid
     * OutOfMemory Exception
     */
    @NotNull
    @Min(value = 1, message = "The number of balls should be minimum 1")
    @Max(value = 10, message = "The number of balls is limited to max 10")
    private Integer balls;
}
