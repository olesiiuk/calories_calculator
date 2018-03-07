package com.jay.calories_calculator.model.handlers;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.domain.SumObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculationHandler {
    public SumObject calculateSum(List<CalendarUnit> foodList) {

        int cal = 0;
        double proteins = 0;
        double fats = 0;
        double starches = 0;

        for (CalendarUnit unit : foodList) {

            int value = unit.getValue();

            cal += (unit.getFood().getCal() / 100) * value;
            proteins += (unit.getFood().getProtein() / 100) * value;
            fats += (unit.getFood().getFats() / 100) * value;
            starches += (unit.getFood().getStarches() / 100) * value;
        }

        SumObject result = new SumObject(cal, proteins, starches, fats);

        return result;
    }
}
