package com.tobioyelami.foodapp.foodapp.restaurant.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by toyelami on 31/01/2019
 */
@Entity(name = "meals")
public class Meal {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "pivot_meal_to_food_item",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = { @JoinColumn(name = "food_item_id")}
            )
    private Set<FoodItem> foodItems = new HashSet<FoodItem>();

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
}
