package com.jay.calories_calculator.model.repisitory;

import com.jay.calories_calculator.model.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findFoodByName(String name);
}
