package com.tobioyelami.foodapp.foodapp.restaurant.repository;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by toyelami on 20/07/2019
 */
@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long>{
}
