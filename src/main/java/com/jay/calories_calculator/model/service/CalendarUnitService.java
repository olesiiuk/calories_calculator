package com.jay.calories_calculator.model.service;

import com.jay.calories_calculator.model.domain.CalendarUnit;

import java.time.LocalDateTime;
import java.util.List;

public interface CalendarUnitService {

    List<CalendarUnit> findByUserIdAndDate(Long userId, LocalDateTime date);

    List<CalendarUnit> findByUserId(Long userId);

}
