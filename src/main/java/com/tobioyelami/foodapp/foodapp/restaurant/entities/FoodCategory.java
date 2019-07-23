package com.tobioyelami.foodapp.foodapp.restaurant.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by toyelami on 17/07/2019
 */
@Entity(name = "food_categories")
public class FoodCategory implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @Column(name = "parent_id")
    private FoodCategory parent = null;

    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private Set<Food> foods = new HashSet<>();


    public FoodCategory() {
    }

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

    public FoodCategory getParent() {
        return parent;
    }

    public void setParent(FoodCategory parent) {
        this.parent = parent;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}
