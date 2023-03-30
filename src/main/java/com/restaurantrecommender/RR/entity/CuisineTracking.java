package com.restaurantrecommender.RR.entity;

import lombok.Data;

@Data
public class CuisineTracking {
    private Cuisine type;
    private int noOfOrders;

}
