package com.restaurantrecommender.RR.controller;

import com.restaurantrecommender.RR.entity.RecommendRequest;
import com.restaurantrecommender.RR.service.RestaurantRecommendationEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommenderController {

    private RestaurantRecommendationEngine restaurantRecommendationEngine;

    @Autowired
    public RecommenderController(RestaurantRecommendationEngine restaurantRecommendationEngine) {
        this.restaurantRecommendationEngine = restaurantRecommendationEngine;
    }

    @PostMapping(path = "/recommend",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> addProvider(@RequestBody RecommendRequest request) throws Exception {
        List<String> recommend = restaurantRecommendationEngine.recommend(request.getUser(), request.getRestaurantList());
        return new ResponseEntity<>(recommend, HttpStatus.CREATED);
    }

}
