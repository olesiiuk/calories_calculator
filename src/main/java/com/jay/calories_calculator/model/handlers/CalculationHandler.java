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

            double tempCal = formatDouble((((double)unit.getFood().getCal()) / 100) * value);
            cal += tempCal;
            unit.getFood().setCal((int) Math.round(tempCal));

            double tempProteins = formatDouble((unit.getFood().getProtein() / 100) * value);
            proteins += tempProteins;
            unit.getFood().setProtein(tempProteins);

            double tempFats = formatDouble((unit.getFood().getFats() / 100) * value);
            fats += tempFats;
            unit.getFood().setFats(tempFats);

            double tempStarches = formatDouble((unit.getFood().getStarches() / 100) * value);
            starches += tempStarches;
            unit.getFood().setStarches(tempStarches);
        }

        SumObject result = new SumObject(cal, proteins, starches, fats);

        return result;
    }

    private double formatDouble(double d) {
        double dd = Math.pow(10, 2);
        return Math.round(d * dd) / dd;
    }

    public void calculateFoodParamsForValue(List<CalendarUnit> list) {

        list.forEach(unit -> {

            int value = unit.getValue();

            int cal = unit.getFood().getCal();
            unit.getFood().setCal((int) Math.round((double) cal / 100) * value);

            double protein = unit.getFood().getProtein();
            unit.getFood().setProtein(formatDouble((protein / 100) * value));

            double fats = unit.getFood().getFats();
            unit.getFood().setFats(formatDouble(((fats / 100) * value)));

            double starches = unit.getFood().getStarches();
            unit.getFood().setStarches(formatDouble(((starches / 100) * value)));

        });
    }
}
