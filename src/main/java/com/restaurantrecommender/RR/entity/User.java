package com.restaurantrecommender.RR.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class User {

    public static int NUMBER_OF_PRIMARY = 1;
    public static int NUMBER_OF_SECONDARY = 2;
    private List<CuisineTracking> cuisines;
    private List<CostTracking> costBracket;

    //preprocess method sort the cuisines and costBracket in decreasing amount of number of orders
    public void preprocess() {
        Collections.sort(cuisines);
        Collections.reverse(cuisines);
        Collections.sort(costBracket);
        Collections.reverse(costBracket);
    }

    public List<Cuisine> getPrimaryCuisines() {
        return cuisines.subList(0, NUMBER_OF_PRIMARY).stream().map(CuisineTracking::getType).collect(Collectors.toList());
    }

    public List<Cuisine> getSecondaryCuisines() {
        return cuisines.subList(NUMBER_OF_PRIMARY, NUMBER_OF_SECONDARY).stream().map(CuisineTracking::getType).collect(Collectors.toList());
    }

    public List<Integer> getPrimaryCostBracket() {
        return costBracket.subList(0, NUMBER_OF_PRIMARY).stream().map(CostTracking::getType).collect(Collectors.toList());
    }

    public List<Integer> getSecondaryCostBracket() {
        return costBracket.subList(NUMBER_OF_PRIMARY, NUMBER_OF_SECONDARY).stream().map(CostTracking::getType).collect(Collectors.toList());
    }

}
