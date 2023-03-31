package com.restaurantrecommender.RR.sorter.sortingstrategies;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;
import com.restaurantrecommender.RR.sorter.RestaurantSorter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewRestaurantSorter extends RestaurantSorter {

    private static final double SECONDS_PER_HOUR = 60.0 * 60.0;
    public static final int NEW_RESTAURANT_MAX_SIZE = 4;
    static double NEW_RESTAURANT_NUMBER_OF_HOURS = 48.0;

    private boolean isRecentlyAdded(Restaurant restaurant) {
        double timeSinceOnboarded = Duration.between(restaurant.getOnboardedTime(), LocalDateTime.now()).toSeconds()/SECONDS_PER_HOUR;
        return timeSinceOnboarded <= NEW_RESTAURANT_NUMBER_OF_HOURS;
    }


    @Override
    protected boolean sortingCondition(SortingContext context, Restaurant restaurant, List<Restaurant> sortedRestaurant) {
        if(isRecentlyAdded(restaurant)){
            sortedRestaurant.add(restaurant);
            sortedRestaurant.sort(Comparator.comparingDouble(Restaurant::getRating));
            Collections.reverse(sortedRestaurant);
            if(sortedRestaurant.size()> NEW_RESTAURANT_MAX_SIZE){
                sortedRestaurant.remove(sortedRestaurant.size()-1);
            }
        }
        return false;
    }
}
