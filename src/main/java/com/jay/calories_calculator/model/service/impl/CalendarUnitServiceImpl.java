package com.jay.calories_calculator.model.service.impl;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.repisitory.CalendarUnitRepository;
import com.jay.calories_calculator.model.service.CalendarUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalendarUnitServiceImpl implements CalendarUnitService {

    @Autowired
    private CalendarUnitRepository calendarUnitRepository;

    @Override
    public List<CalendarUnit> findByUserIdAndDate(Long userId, LocalDateTime date) {
        return calendarUnitRepository.findByUserIdAndDate(userId, date);
    }

    @Override
    public List<CalendarUnit> findByUserId(Long userId) {
        return calendarUnitRepository.findByUserId(userId);
    }
}
