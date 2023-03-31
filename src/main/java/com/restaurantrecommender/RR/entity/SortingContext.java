package com.restaurantrecommender.RR.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortingContext {
    User user;
    Map<String,Restaurant> availableRestaurants;
    List<String> sortedRestaurants;
}
