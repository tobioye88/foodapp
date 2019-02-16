package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.Meal;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodItemModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.MealModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.MealRequest;
import com.tobioyelami.foodapp.foodapp.restaurant.repository.MealRepository;
import com.tobioyelami.foodapp.foodapp.restaurant.utility.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by toyelami on 31/01/2019
 */
@Service
public class MealService extends BaseService<Meal> {

    private FoodItemService foodItemService;

    @Autowired
    public MealService(MealRepository repository, FoodItemService foodItemService){
        super(repository);
        this.foodItemService = foodItemService;
    }

    @Transactional
    public MealModel add(MealRequest request) {
        MealModel model = request.getMeal();
        if(model == null){
            return null;
        }

        Meal meal = save(Converter.mealModelToEntity(model));
        List<Long> foodItemsIds = request.getFoodItemsIds();
        List<FoodItemModel> foodItems = request.getFoodItems();

        addFoodItemToMeal(model, foodItems, foodItemsIds);
        return model;
    }

    public MealModel edit(MealRequest request) {
        MealModel meal = request.getMeal();
        if(meal == null) {
            return null;
        }

        save(Converter.mealModelToEntity(meal));
        addFoodItemToMeal(meal, request.getFoodItems(), request.getFoodItemsIds());
        return meal;
    }

    private void addFoodItemToMeal(MealModel meal, List<FoodItemModel> foodItems, List<Long> foodItemsIds) {
        List<FoodItem> menuFoodItems = new ArrayList<>();
        if(!foodItemsIds.isEmpty()){
            List<FoodItem> foodList = foodItemService.findByIds(foodItemsIds);
            menuFoodItems.addAll(foodList);
        }
        if(!foodItems.isEmpty()){
            try {
                foodItems.forEach(foodItem -> {
                    FoodItem savedFooItem = foodItemService.save(Converter.foodItemModelToEntity(foodItem));
                    menuFoodItems.add(savedFooItem);
                });
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        meal.setFoodItems(Converter.foodItemEntityToModel(new HashSet<>(menuFoodItems)));
        save(Converter.mealModelToEntity(meal));
    }
}
