package com.jay.calories_calculator.model.service.api;

import com.jay.calories_calculator.model.domain.Food;

import java.util.List;

public interface FoodService {

    List<Food> findAllFood();

    void saveFood(Food food);

    Food findFoodByName(String name);

    Food findFoodById(Long id);
}
