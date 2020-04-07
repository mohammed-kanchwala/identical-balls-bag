package com.bayzat;

import lombok.Data;

import java.util.List;

@Data
public class BagsResponse {
    Integer totalNoOfWays;
    List<String> methods;
}
