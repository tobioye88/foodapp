package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodCategory;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodRequest;
import com.tobioyelami.foodapp.foodapp.restaurant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by toyelami on 31/01/2019
 */
@Service
public class FoodService extends BaseService<Food> {

    private FoodItemService foodItemService;
    private FileService fileService;
    private FoodRepository foodRepository;
    private FoodCategoryService foodCategoryService;

    @Autowired
    public FoodService(FoodRepository repository, FoodItemService foodItemService, FoodCategoryService foodCategoryService, FileService fileService){
        super(repository);
        this.foodRepository = repository;
        this.foodItemService = foodItemService;
        this.fileService = fileService;
        this.foodCategoryService = foodCategoryService;
    }

    public ResponseEntity<Food> add(FoodRequest request) throws FileNotFoundException {
        return add(request, null);
    }

    @Transactional
    public ResponseEntity<Food> add(FoodRequest request, MultipartFile file) throws FileNotFoundException {
        Food food = request.getFood();
        if(food == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Long> foodItemsIds = request.getFoodItemsIds();
        List<FoodItem> foodItems = request.getFoodItems();

        if(file == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        File savedFile = fileService.save(file);
        addFoodItemToFood(food, foodItems, foodItemsIds);
        food.setImagePath(savedFile.getName());
        save(food);

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    public ResponseEntity<Food> edit(FoodRequest request) {
        Food food = request.getFood();
        if(food == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        addFoodToCategory(food, request.getCategoryIds());
        addFoodItemToFood(food, request.getFoodItems(), request.getFoodItemsIds());
        food = save(food);

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    private  void addFoodToCategory(Food food, List<Long> foodCategoryIds){
        Set<FoodCategory> foodCategories = food.getCategories();

        if(foodCategoryIds != null && !foodCategoryIds.isEmpty()){
            List<FoodCategory> byIds = foodCategoryService.findByIds(foodCategoryIds);
            foodCategories.addAll(byIds);
        }
    }

    private void addFoodItemToFood(Food food, List<FoodItem> foodItems, List<Long> foodItemsIds) {
        Set<FoodItem> previousFoodItems = food.getFoodItems();

        if(foodItemsIds != null && !foodItemsIds.isEmpty()){
            List<FoodItem> foodList = foodItemService.findByIds(foodItemsIds);
            previousFoodItems.addAll(foodList);
        }

        if(foodItems != null && !foodItems.isEmpty()){
            try {
                foodItems.forEach(foodItem -> {
                    FoodItem savedFooItem = foodItemService.save(foodItem);
                    previousFoodItems.add(savedFooItem);
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        food.setFoodItems(previousFoodItems);
    }

    public ResponseEntity<List<Food>> search(String keyword) {
        List<Food> foodList = this.foodRepository.findByNameContaining(keyword);
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    public ResponseEntity<List<Food>> findByCategory(String category) {
        List<Food> foodList = this.foodRepository.findByCategories_NameIn(Collections.singleton(category));
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    public ResponseEntity<Long> count(){
        long count = this.foodRepository.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
