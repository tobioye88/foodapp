package com.tobioyelami.foodapp.foodapp.restaurant.controller;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodItemModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodRequest;
import com.tobioyelami.foodapp.foodapp.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * Created by toyelami on 31/01/2019
 */
@RestController
@RequestMapping(value = "v1/menu")
public class FoodController extends BaseController<Food> {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        super(foodService);
        this.foodService = foodService;
    }

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public ResponseEntity<FoodModel> add(@RequestPart("request") FoodRequest request,
                                         @RequestPart("files") MultipartFile files) throws FileNotFoundException {
        return foodService.add(request, files);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<FoodModel> edit(@RequestBody FoodRequest request){
        return foodService.edit(request);
    }

}
