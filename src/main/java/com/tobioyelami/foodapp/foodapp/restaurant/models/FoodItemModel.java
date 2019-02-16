package com.tobioyelami.foodapp.foodapp.restaurant.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by toyelami on 05/02/2019
 */
public class FoodItemModel {
    private long id;
    private String name;
    private String description;
    private double price;
    private int portions;
    private boolean isAvailable = true;
    private boolean isVisible = true;
    private boolean isDeleted = false;
    private Date createdAt = new Date();
    private Set<MealModel> meals = new HashSet<MealModel>();

    public FoodItemModel() {
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

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(Set<MealModel> meals) {
        this.meals = meals;
    }
}
