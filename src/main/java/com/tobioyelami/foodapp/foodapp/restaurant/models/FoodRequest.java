package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by toyelami on 02/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodRequest {
    private Food food;
    private List<Food> foods;
    private List<FoodItem> foodItems;
    private List<Long> foodItemsIds;
    private MultipartFile[] files;
    private List<Long> categoryIds;

    public FoodRequest() {
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> meals) {
        this.foods = meals;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
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

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
