package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by toyelami on 02/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodRequest {
    private FoodModel meal;
    private List<FoodModel> meals;
    private List<FoodItemModel> foodItems;
    private List<Long> foodItemsIds;
    private MultipartFile[] files;

    public FoodRequest() {
    }

    public FoodModel getMeal() {
        return meal;
    }

    public void setMeal(FoodModel meal) {
        this.meal = meal;
    }

    public List<FoodModel> getMeals() {
        return meals;
    }

    public void setMeals(List<FoodModel> meals) {
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

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
