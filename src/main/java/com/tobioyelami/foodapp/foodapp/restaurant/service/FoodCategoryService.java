package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodCategory;
import com.tobioyelami.foodapp.foodapp.restaurant.repository.FoodCategoryRepository;
import org.springframework.stereotype.Service;

/**
 * Created by toyelami on 20/07/2019
 */
@Service
public class FoodCategoryService extends BaseService<FoodCategory> {

    public FoodCategoryService(FoodCategoryRepository repository) {
        super(repository);
    }
}
