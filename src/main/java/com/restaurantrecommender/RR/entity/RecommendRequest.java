package com.restaurantrecommender.RR.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendRequest {
    User user;
    List<Restaurant> restaurantList;
}
