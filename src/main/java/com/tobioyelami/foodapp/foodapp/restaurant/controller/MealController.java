package com.tobioyelami.foodapp.foodapp.restaurant.controller;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.Meal;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodItemModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.MealModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.MealRequest;
import com.tobioyelami.foodapp.foodapp.restaurant.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by toyelami on 31/01/2019
 */
@RestController
@RequestMapping(value = "v1/menu")
public class MealController extends BaseController<Meal> {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService){
        super(mealService);
        this.mealService = mealService;
    }

    @PostMapping("/add")
    public ResponseEntity<MealModel> add(@RequestBody MealRequest request){
        MealModel added = mealService.add(request);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MealModel> edit(@RequestBody MealRequest request){
        MealModel added = mealService.edit(request);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test(@RequestBody FoodItemModel request){
        System.out.println(request);
        return "error";
    }

}
