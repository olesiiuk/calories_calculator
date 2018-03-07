package com.jay.calories_calculator.model.service.impl;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.repisitory.CalendarUnitRepository;
import com.jay.calories_calculator.model.service.api.CalendarUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarUnitServiceImpl implements CalendarUnitService {

    @Autowired
    private CalendarUnitRepository calendarUnitRepository;

    @Override
    public List<CalendarUnit> findByUserIdAndDate(Long userId, LocalDate date) {
        return calendarUnitRepository.findByUserIdAndDate(userId, date);
    }

    @Override
    public List<CalendarUnit> findByUserId(Long userId) {
        return calendarUnitRepository.findByUserId(userId);
    }

    @Override
    public void save(CalendarUnit calendarUnit) {
        calendarUnitRepository.save(calendarUnit);
    }

    @Override
    public List<CalendarUnit> findByUserIdAndDateBetween(Long id, LocalDate firsDate, LocalDate lastDate) {
        return calendarUnitRepository.findByUserIdAndDateBetweenOrderByTime(id, firsDate, lastDate);
    }
}
