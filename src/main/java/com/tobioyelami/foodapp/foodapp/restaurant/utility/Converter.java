package com.tobioyelami.foodapp.foodapp.restaurant.utility;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Meal;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodItemModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.MealModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by toyelami on 06/02/2019
 */
public class Converter {

    public static List<Meal> mealModelListToEntityList(List<MealModel> models)  {
        List<Meal> meals = new ArrayList<>();
        for (MealModel model : models) {
            meals.add(mealModelToEntity(model));
        }
        return meals;
    }

    public static Meal mealModelToEntity(MealModel model)  {
        if(model == null){
            return null;
        }

        Meal meal = new Meal();
        meal.setId(model.getId());
        meal.setName(model.getName());
        meal.setDescription(model.getDescription());
        meal.setFoodItems(foodItemModelToEntity(model.getFoodItems()));

        return meal;
    }

    public static List<MealModel> mealEntityListToModelList(List<Meal> entities)  {
        List<MealModel> models = new ArrayList<>();
        for (Meal entity : entities) {
            models.add(mealEntityToModel(entity));
        }
        return models;
    }

    public static MealModel mealEntityToModel(Meal entity){
        if(entity == null){
            return null;
        }

        MealModel model = new MealModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setFoodItems(foodItemEntityToModel(entity.getFoodItems()));
        model.setPrice(entity.getPrice());

        return model;
    }

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
