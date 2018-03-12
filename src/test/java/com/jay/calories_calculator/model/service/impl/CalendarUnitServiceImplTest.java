package com.jay.calories_calculator.model.service.impl;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.domain.Food;
import com.jay.calories_calculator.model.service.api.CalendarUnitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarUnitServiceImplTest {


    @Autowired
    CalendarUnitService calendarUnitService;

    @Test
    public void findByUserIdAndDate() {


        List<CalendarUnit> calendarUnits =
                calendarUnitService.findByUserIdAndDate(2L, LocalDate.of(2018, 3, 7));

        Food food = new Food("Detached food", 111, 12d, 12d, 12d);

        calendarUnits.forEach(calendarUnit -> calendarUnit.setFood(food));

        System.out.println("\n ================================================ \n");

        calendarUnits.forEach(calendarUnit -> {
            System.out.println(calendarUnit.getFood());
        });
    }

}