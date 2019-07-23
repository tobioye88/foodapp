package com.tobioyelami.foodapp.foodapp.restaurant.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by toyelami on 31/01/2019
 */
@Entity(name = "foods")
public class Food implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name="image_path")
    private String imagePath;

    private String description;

    @ManyToMany
    private Set<FoodCategory> categories = new HashSet<>();

    @ManyToMany
    private Set<FoodItem> foodItems = new HashSet<>();

    private int packageNumber;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public double getPrice(){
        double price = 0d;
        for (FoodItem foodItem : this.foodItems) {
            price += foodItem.getPrice();
        }
        return price;
    }

    public int getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(int packageNumber) {
        this.packageNumber = packageNumber;
    }

    public Set<FoodCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<FoodCategory> categories) {
        this.categories = categories;
    }
}
