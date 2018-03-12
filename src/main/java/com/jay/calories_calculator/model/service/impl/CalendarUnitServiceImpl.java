package com.jay.calories_calculator.model.service.impl;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.repisitory.CalendarUnitRepository;
import com.jay.calories_calculator.model.service.api.CalendarUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarUnitServiceImpl implements CalendarUnitService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CalendarUnitRepository calendarUnitRepository;

    @Override
    public List<CalendarUnit> findByUserIdAndDate(Long userId, LocalDate date) {

        List<CalendarUnit> calendarUnits = calendarUnitRepository.findByUserIdAndDate(userId, date);

        calendarUnits.forEach(entityManager::detach);

        return calendarUnits;
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

        List<CalendarUnit> calendarUnits =
                calendarUnitRepository.findByUserIdAndDateBetweenOrderByTime(id, firsDate, lastDate);

        calendarUnits.forEach(calendarUnit -> entityManager.detach(calendarUnit));

        return calendarUnits;
    }
}
