package com.restaurantrecommender.RR.entity;

import lombok.Data;

@Data
public class CuisineTracking implements Comparable<CuisineTracking>{
    private Cuisine type;
    private int noOfOrders;


    @Override
    public int compareTo(CuisineTracking another) {
        return Integer.compare(noOfOrders, another.noOfOrders);
    }
}
