package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by toyelami on 02/02/2019
 */
public class MealResponse {
    private long id;
    private String name;
    private String description;
    private double price;
    private List<Item> foodItems;

    private MealResponse() { }

    public static MealResponse response(Meal meal){
        MealResponse mealResponse = new MealResponse();
        mealResponse.setName(meal.getName());
        mealResponse.setDescription(meal.getDescription());
        mealResponse.setPrice(meal.getPrice());
        mealResponse.setId(meal.getId());
        mealResponse.setFoodItems(convertFoodItems(meal.getFoodItems()));
        return mealResponse;
    }

    private static List<Item> convertFoodItems(Set<FoodItem> foodItems) {
        List<MealResponse.Item> items = new ArrayList<>();
        for (FoodItem foodItem: foodItems){
            items.add(new MealResponse.Item(foodItem.getId(), foodItem.getName(), foodItem.getDescription(), foodItem.getPrice()));
        }
        return items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Item> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Item> foodItems) {
        this.foodItems = foodItems;
    }

    private static class Item {
        private Long id;
        private String name;
        private String description;
        private double price;

        public Item(Long id, String name, String description, double price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }
}
