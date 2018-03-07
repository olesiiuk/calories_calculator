package com.jay.calories_calculator.model.service.api;

import com.jay.calories_calculator.model.domain.CalendarUnit;

import java.time.LocalDate;
import java.util.List;

public interface CalendarUnitService {

    List<CalendarUnit> findByUserIdAndDate(Long userId, LocalDate date);

    List<CalendarUnit> findByUserId(Long userId);

    void save(CalendarUnit calendarUnit);

    List<CalendarUnit> findByUserIdAndDateBetween(Long id, LocalDate firsDate, LocalDate lastDate);

}
