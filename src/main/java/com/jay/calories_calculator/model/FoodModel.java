package com.jay.calories_calculator.model;

import com.jay.calories_calculator.model.domain.Food;

import java.util.List;

public class FoodModel {
    private List<Food> foodList;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
