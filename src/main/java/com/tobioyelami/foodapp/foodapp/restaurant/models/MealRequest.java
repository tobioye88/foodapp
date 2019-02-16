package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by toyelami on 02/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealRequest {
    private MealModel meal;
    private List<MealModel> meals;
    private List<FoodItemModel> foodItems;
    private List<Long> foodItemsIds;

    public MealRequest() {
    }

    public MealModel getMeal() {
        return meal;
    }

    public void setMeal(MealModel meal) {
        this.meal = meal;
    }

    public List<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(List<MealModel> meals) {
        this.meals = meals;
    }

    public List<FoodItemModel> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemModel> foodItems) {
        this.foodItems = foodItems;
    }

    public List<Long> getFoodItemsIds() {
        return foodItemsIds;
    }

    public void setFoodItemsIds(List<Long> foodItemsIds) {
        this.foodItemsIds = foodItemsIds;
    }
}
