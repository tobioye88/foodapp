package com.tobioyelami.foodapp.foodapp.restaurant.repository;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by toyelami on 31/01/2019
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByNameContaining(String keyword);

    List<Food> findByCategories_NameIn(Collection<String> singleton);
}
