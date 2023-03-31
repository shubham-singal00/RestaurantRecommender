package com.restaurantrecommender.RR.sorter;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class RestaurantSorter {


    public SortingContext sort(SortingContext context) {
        List<Restaurant> sortedRestaurant = new ArrayList<>();
        for (Map.Entry<String, Restaurant> stringRestaurantEntry : context.getAvailableRestaurants().entrySet()) {
            Restaurant restaurant = stringRestaurantEntry.getValue();
            if (sortingCondition(context, restaurant, sortedRestaurant)) {
                sortedRestaurant.add(restaurant);
            }
        }
        for (Restaurant restaurant : sortedRestaurant) {
            context.getAvailableRestaurants().remove(restaurant.getRestaurantId());
            context.getSortedRestaurants().add(restaurant.getRestaurantId());
        }
        return context;
    }

    protected abstract boolean sortingCondition(SortingContext context, Restaurant restaurant, List<Restaurant> sortedRestaurant);

}