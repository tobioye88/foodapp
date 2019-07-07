package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.tobioyelami.foodapp.foodapp.restaurant.entities.Food;
import com.tobioyelami.foodapp.foodapp.restaurant.entities.FoodItem;
import com.tobioyelami.foodapp.foodapp.restaurant.exceptions.AppSericeException;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodItemModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodModel;
import com.tobioyelami.foodapp.foodapp.restaurant.models.FoodRequest;
import com.tobioyelami.foodapp.foodapp.restaurant.repository.MealRepository;
import com.tobioyelami.foodapp.foodapp.restaurant.utility.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by toyelami on 31/01/2019
 */
@Service
public class FoodService extends BaseService<Food> {

    private FoodItemService foodItemService;
    private FileService fileService;

    @Autowired
    public FoodService(MealRepository repository, FoodItemService foodItemService, FileService fileService){
        super(repository);
        this.foodItemService = foodItemService;
        this.fileService = fileService;
    }

    public ResponseEntity<FoodModel> add(FoodRequest request) throws FileNotFoundException {
        return add(request, null);
    }

    @Transactional
    public ResponseEntity<FoodModel> add(FoodRequest request, MultipartFile file) throws FileNotFoundException {
        FoodModel model = request.getMeal();
        if(model == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Long> foodItemsIds = request.getFoodItemsIds();
        List<FoodItemModel> foodItems = request.getFoodItems();

        if(file == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        File savedFile = fileService.save(file);
        addFoodItemToMeal(model, foodItems, foodItemsIds);
        Food foodEntity = save(Converter.mealModelToEntity(model));
        foodEntity.setImagePath(savedFile.getName());

        model = Converter.mealEntityToModel(foodEntity);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    public ResponseEntity<FoodModel> edit(FoodRequest request) {
        FoodModel model = request.getMeal();
        if(model == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Food mealEntity = save(Converter.mealModelToEntity(model));
        addFoodItemToMeal(model, request.getFoodItems(), request.getFoodItemsIds());

        model = Converter.mealEntityToModel(mealEntity);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    private void addFoodItemToMeal(FoodModel meal, List<FoodItemModel> foodItems, List<Long> foodItemsIds) {
        List<FoodItem> menuFoodItems = new ArrayList<>();

        if(foodItemsIds != null && !foodItemsIds.isEmpty()){
            List<FoodItem> foodList = foodItemService.findByIds(foodItemsIds);
            menuFoodItems.addAll(foodList);
        }

        if(foodItems != null && !foodItems.isEmpty()){
            try {
                foodItems.forEach(foodItem -> {
                    FoodItem savedFooItem = foodItemService.save(Converter.foodItemModelToEntity(foodItem));
                    menuFoodItems.add(savedFooItem);
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        meal.setFoodItems(Converter.foodItemEntityToModel(new HashSet<>(menuFoodItems)));
    }
}
