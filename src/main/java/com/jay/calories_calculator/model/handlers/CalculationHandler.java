package com.jay.calories_calculator.model.handlers;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.domain.SumObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculationHandler {
    public SumObject calculateSum(List<CalendarUnit> foodList) {

        double cal = 0;
        double proteins = 0;
        double fats = 0;
        double starches = 0;

        for (CalendarUnit unit : foodList) {

            int value = unit.getValue();

            cal += formatDouble((((double)unit.getFood().getCal()) / 100) * value);

            proteins += formatDouble((unit.getFood().getProtein() / 100) * value);
            fats += formatDouble((unit.getFood().getFats() / 100) * value);
            starches += formatDouble((unit.getFood().getStarches() / 100) * value);
        }

        SumObject result = new SumObject(cal, proteins, starches, fats);

        return result;
    }

    private double formatDouble(double d) {
        double dd = Math.pow(10, 2);
        return Math.round(d * dd) / dd;
    }
}
