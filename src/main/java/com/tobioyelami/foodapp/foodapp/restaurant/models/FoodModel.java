package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;

import java.util.Set;

/**
 * Created by toyelami on 05/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodModel extends Food {
    public Set<Long> categoryIds;
    private double price;

    public FoodModel() {
    }

    public Set<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
