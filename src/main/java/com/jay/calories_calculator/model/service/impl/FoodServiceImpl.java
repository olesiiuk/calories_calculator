package com.jay.calories_calculator.model.service.impl;

import com.jay.calories_calculator.model.domain.Food;
import com.jay.calories_calculator.model.repisitory.FoodRepository;
import com.jay.calories_calculator.model.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;


    @Override
    public List<Food> findAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public void saveFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public Food findFoodByName(String name) {
        return foodRepository.findFoodByName(name);
    }
}
