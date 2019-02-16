package com.tobioyelami.foodapp.foodapp.restaurant.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by toyelami on 05/02/2019
 */
public class MealModel {
    private long id;
    private String name;
    private String description;
    private Set<FoodItemModel> foodItems = new HashSet<>();
    private int packageNumber;
    private double price;

    public MealModel(){}

    public MealModel(long id, String name, String description, Set<FoodItemModel> foodItems, int packageNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodItems = foodItems;
        this.packageNumber = packageNumber;
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

    public Set<FoodItemModel> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItemModel> foodItems) {
        this.foodItems = foodItems;
    }

    public int getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(int packageNumber) {
        this.packageNumber = packageNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}