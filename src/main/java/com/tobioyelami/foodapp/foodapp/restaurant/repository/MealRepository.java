package com.tobioyelami.foodapp.foodapp.restaurant.repository;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by toyelami on 31/01/2019
 */
@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
