package com.jay.calories_calculator.model.handlers;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.domain.Food;
import com.jay.calories_calculator.model.domain.SumObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CalculationHandlerTest {

    @Test
    public void calculateSum() {
        CalculationHandler handler = new CalculationHandler();

        CalendarUnit unit1 = new CalendarUnit();
        unit1.setValue(100);
        CalendarUnit unit2 = new CalendarUnit();
        unit2.setValue(100);

        Food food1 = new Food("name1", 1, 1.5, 2.1, 1.7);
        Food food2 = new Food("name2", 1, 1.5, 2.1, 1.7);

        unit1.setFood(food1);
        unit2.setFood(food2);

        List<CalendarUnit> list = Arrays.asList(unit1, unit2);

        SumObject result = handler.calculateSum(list);
        SumObject expected = new SumObject(2d, 3.0, 4.2, 3.4);


        assertEquals(result, expected);
    }



}