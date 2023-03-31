package com.restaurantrecommender.RR.controller;

import com.restaurantrecommender.RR.entity.RecommendRequest;
import com.restaurantrecommender.RR.service.RestaurantRecommenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommenderController {

    private RestaurantRecommenderService restaurantRecommenderService;

    @Autowired
    public RecommenderController(RestaurantRecommenderService restaurantRecommenderService) {
        this.restaurantRecommenderService = restaurantRecommenderService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<String> hello() throws Exception {
        return new ResponseEntity<>("YO", HttpStatus.OK);
    }

    @PostMapping(path = "/recommend",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> addProvider(@RequestBody RecommendRequest request) throws Exception {
        List<String> recommend = restaurantRecommenderService.recommend(request.getUser(), request.getRestaurantList());
        return new ResponseEntity<>(recommend, HttpStatus.CREATED);
    }
}
