package com.restaurantrecommender.RR.sorter.sortingstrategies;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;
import com.restaurantrecommender.RR.sorter.RestaurantSorter;

import java.util.List;

public class FeaturedRemainingSorter extends RestaurantSorter {

    @Override
    protected boolean sortingCondition(SortingContext context, Restaurant restaurant, List<Restaurant> sortedRestaurant) {
        return context.getSortedRestaurants().isEmpty() &&  // This runs only if output of 1st rule is empty
                restaurant.isRecommended() &&
                ((context.getUser().getPrimaryCuisines().contains(restaurant.getCuisine()) &&
                        context.getUser().getSecondaryCostBracket().contains(restaurant.getCostBracket())) ||
                        (context.getUser().getSecondaryCuisines().contains(restaurant.getCuisine()) &&
                                context.getUser().getPrimaryCostBracket().contains(restaurant.getCostBracket())));
    }
}
