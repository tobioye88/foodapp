package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by toyelami on 02/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodResponse {
    private long id;
    private String name;
    private String description;
    private double price;
    private List<Item> foodItems;

    private FoodResponse() { }

    public static FoodResponse response(Food food){
        FoodResponse foodResponse = new FoodResponse();
        foodResponse.setName(food.getName());
        foodResponse.setDescription(food.getDescription());
        foodResponse.setPrice(food.getPrice());
        foodResponse.setId(food.getId());
        foodResponse.setFoodItems(convertFoodItems(food.getFoodItems()));
        return foodResponse;
    }

    private static List<Item> convertFoodItems(Set<FoodItem> foodItems) {
        List<FoodResponse.Item> items = new ArrayList<>();
        for (FoodItem foodItem: foodItems){
            items.add(new FoodResponse.Item(foodItem.getId(), foodItem.getName(), foodItem.getDescription(), foodItem.getPrice()));
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
