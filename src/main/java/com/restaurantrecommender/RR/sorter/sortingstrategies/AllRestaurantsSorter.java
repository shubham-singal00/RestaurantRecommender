package com.restaurantrecommender.RR.sorter.sortingstrategies;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;
import com.restaurantrecommender.RR.sorter.RestaurantSorter;

import java.util.List;

public class AllRestaurantsSorter extends RestaurantSorter {

    @Override
    protected boolean sortingCondition(SortingContext context, Restaurant restaurant, List<Restaurant> sortedRestaurant) {
        return true;
    }
}
