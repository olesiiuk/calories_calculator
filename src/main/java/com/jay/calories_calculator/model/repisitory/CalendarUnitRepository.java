package com.jay.calories_calculator.model.repisitory;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalendarUnitRepository extends JpaRepository<CalendarUnit, Long> {

    List<CalendarUnit> findByUserIdAndDate(Long userId, LocalDate date);

    List<CalendarUnit> findByUserId(Long userId);

    List<CalendarUnit> findByUserIdAndDateBetweenOrderByTime(Long id, LocalDate firstDate, LocalDate lastDate);
}
