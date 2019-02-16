package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by toyelami on 31/01/2019
 */
@Service
public class FoodItemService extends BaseService<FoodItem>{

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository){
        super(foodItemRepository);
    }
}
