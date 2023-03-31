package com.restaurantrecommender.RR.sorter.sortingstrategies;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;
import com.restaurantrecommender.RR.sorter.RestaurantSorter;

import java.util.List;

public class FeaturedPrimaryCuisinePrimaryCostSorter extends RestaurantSorter {
    @Override
    protected boolean sortingCondition(SortingContext context, Restaurant restaurant, List<Restaurant> sortedRestaurant) {
        return restaurant.isRecommended() &&
                context.getUser().getPrimaryCuisines().contains(restaurant.getCuisine()) &&
                context.getUser().getPrimaryCostBracket().contains(restaurant.getCostBracket());
    }
}
