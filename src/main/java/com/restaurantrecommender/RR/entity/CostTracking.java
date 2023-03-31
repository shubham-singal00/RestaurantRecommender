package com.restaurantrecommender.RR.entity;

import lombok.Data;

@Data
public class CostTracking implements Comparable<CostTracking>{
    private int type;
    private int noOfOrders;

    @Override
    public int compareTo(CostTracking another) {
        return Integer.compare(noOfOrders, another.noOfOrders);
    }
}
