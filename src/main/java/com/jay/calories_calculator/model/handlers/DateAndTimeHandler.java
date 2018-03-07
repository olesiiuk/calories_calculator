package com.jay.calories_calculator.model.handlers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class DateAndTimeHandler {

    static {
        hours = Arrays.asList("00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00",
                "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00",
                "20:00", "21:00", "22:00", "23:00", "24:00");
    }

    private final static DateTimeFormatter DATE_AND_HOURS_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private static List<String> hours;

    public static String getNowDate() {

        LocalDate nowDate = LocalDate.now();

        return nowDate.format(DATE_FORMATTER);
    }

    public static String getNowTime() {
        LocalTime nowTime = LocalTime.now();

        LocalTime hours = LocalTime.of(nowTime.getHour(), 0);

        return hours.format(TIME_FORMATTER);
    }

    public static List<String> getHours() {
        return hours;
    }
}
