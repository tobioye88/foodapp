package com.tobioyelami.foodapp.foodapp.restaurant.utility;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodItemModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by toyelami on 06/02/2019
 */
public class Converter {

    private Converter(){}


    public static FoodItem foodItemModelToEntity(FoodItemModel model){
        if(model == null){
            return null;
        }

        FoodItem item = new FoodItem();
        item.setAvailable(model.isAvailable());
        item.setCreatedAt(model.getCreatedAt());
        item.setDeleted(model.isDeleted());
        item.setDescription(model.getDescription());
        item.setName(model.getName());
        item.setPortions(model.getPortions());
        item.setId(model.getId());
        item.setPrice(model.getPrice());
        item.setPortions(model.getPortions());
        item.setImagePath(model.getImagePath());
        return item;
    }

    public static HashSet<FoodItem> foodItemModelToEntity(Set<FoodItemModel> models){
        HashSet<FoodItem> entities = new HashSet<>();

        if(!models.isEmpty()){
            models.forEach(foodItemModel -> {
                entities.add(foodItemModelToEntity(foodItemModel));
            });
        }
        return entities;
    }

    public static FoodItemModel foodItemEntityToModel(FoodItem entity){
        if(entity == null){
            return null;
        }

        FoodItemModel model = new FoodItemModel();
        model.setAvailable(entity.isAvailable());
        model.setCreatedAt(entity.getCreatedAt());
        model.setDeleted(entity.isDeleted());
        model.setDescription(entity.getDescription());
        model.setName(entity.getName());
        model.setPortions(entity.getPortions());
        model.setId(entity.getId());
        return model;
    }

    public static Set<FoodItemModel> foodItemEntityToModel(Set<FoodItem> foodList) {
        Set<FoodItemModel> models = new HashSet<>();

        if(!foodList.isEmpty()){
            foodList.forEach(foodItem -> {
                models.add(foodItemEntityToModel(foodItem));
            });
        }
        return models;
    }
}
