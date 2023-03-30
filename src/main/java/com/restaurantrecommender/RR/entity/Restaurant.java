package com.restaurantrecommender.RR.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Restaurant {
    private String restaurantId;
    private Cuisine cuisine;
    private int costBracket;
    private float rating;
    private boolean isRecommended;
    private LocalDate onboardedTime;

}
