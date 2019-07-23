package com.tobioyelami.foodapp.foodapp.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;

/**
 * Created by toyelami on 05/02/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodItemModel extends FoodItem {
    public FoodItemModel() {
    }
}
