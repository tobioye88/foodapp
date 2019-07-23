package com.tobioyelami.foodapp.foodapp.restaurant.controller;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodCategory;
import com.tobioyelami.foodapp.foodapp.restaurant.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by toyelami on 20/07/2019
 */
@RestController
@RequestMapping("/v1/categories")
public class FoodCategoryController extends BaseController<FoodCategory> {

    @Autowired
    public FoodCategoryController(FoodCategoryService service) {
        super(service);
    }
}
