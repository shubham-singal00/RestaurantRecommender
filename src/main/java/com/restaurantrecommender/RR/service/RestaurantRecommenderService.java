package com.restaurantrecommender.RR.service;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;
import com.restaurantrecommender.RR.entity.User;
import com.restaurantrecommender.RR.sorter.sortingstrategies.*;
import com.restaurantrecommender.RR.sorter.RestaurantSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantRecommenderService {

    private List<RestaurantSorter> sorters;

    private static int RECOMMENDATION_LIMIT = 100;

    @Autowired
    public RestaurantRecommenderService() {
        sorters = new ArrayList<>();
        sorters.add(new FeaturedPrimaryCuisinePrimaryCostSorter());
        sorters.add(new FeaturedRemainingSorter());

        sorters.add(new PrimaryCuisinePrimaryCostRatingSorter(4,false));
        sorters.add(new PrimaryCuisineSecondaryCostRatingSorter(4.5,false));
        sorters.add(new SecondaryCuisinePrimaryCostRatingSorter(4.5,false));
        sorters.add(new NewRestaurantSorter());

        sorters.add(new PrimaryCuisinePrimaryCostRatingSorter(4, true ));
        sorters.add(new PrimaryCuisineSecondaryCostRatingSorter(4.5, true));
        sorters.add(new SecondaryCuisinePrimaryCostRatingSorter(4.5, true));
        sorters.add(new AllRestaurantsSorter());
    }

    public List<String> recommend(User user, List<Restaurant> restaurantList) {
        user.preprocess();
        HashMap<String, Restaurant> availableRestaurants = getIdRestaurantMap(restaurantList);
        SortingContext context = new SortingContext(user, availableRestaurants, new ArrayList<String>());
        for (RestaurantSorter sorter : sorters) {
            sorter.sort(context);
        }
        return context.getSortedRestaurants().stream()
                .distinct()
                .limit(RECOMMENDATION_LIMIT)
                .collect(Collectors.toList());
    }

    private static HashMap<String, Restaurant> getIdRestaurantMap(List<Restaurant> restaurantList) {
        HashMap<String, Restaurant> availableRestaurants = new HashMap<>();
        for (Restaurant restaurant : restaurantList) {
            availableRestaurants.put(restaurant.getRestaurantId(), restaurant);
        }
        return availableRestaurants;
    }
}
