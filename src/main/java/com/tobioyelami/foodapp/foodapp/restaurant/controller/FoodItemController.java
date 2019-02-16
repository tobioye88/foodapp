package com.tobioyelami.foodapp.foodapp.restaurant.controller;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by toyelami on 02/02/2019
 */
@RestController
@RequestMapping("v1/food_items")
public class FoodItemController extends BaseController<FoodItem> {

    @Autowired
    public FoodItemController (FoodItemService foodItemService){
        super(foodItemService);
    }
}
