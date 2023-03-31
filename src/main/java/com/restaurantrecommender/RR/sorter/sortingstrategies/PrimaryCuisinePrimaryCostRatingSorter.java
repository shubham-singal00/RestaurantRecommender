package com.restaurantrecommender.RR.sorter.sortingstrategies;

import com.restaurantrecommender.RR.entity.Restaurant;
import com.restaurantrecommender.RR.entity.SortingContext;
import com.restaurantrecommender.RR.sorter.RestaurantSorter;

import java.util.List;

public class PrimaryCuisinePrimaryCostRatingSorter extends RestaurantSorter {
    double rating;
    boolean smallerThan;

    public PrimaryCuisinePrimaryCostRatingSorter(double rating, boolean smallerThan) {
        this.rating = rating;
        this.smallerThan = smallerThan;
    }

    @Override
    protected boolean sortingCondition(SortingContext context, Restaurant restaurant, List<Restaurant> sortedRestaurant) {
        return context.getUser().getPrimaryCuisines().contains(restaurant.getCuisine()) &&
                context.getUser().getPrimaryCostBracket().contains(restaurant.getCostBracket()) &&
                (smallerThan == (restaurant.getRating() < this.rating));
    }
}
