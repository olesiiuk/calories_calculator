package com.jay.calories_calculator.model.domain.validators;

import com.jay.calories_calculator.model.domain.Food;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Component
public class FoodValidator implements Validator {

    private Pattern pattern;

    private Matcher matcher;

    private static final String DOUBLE_PATTERN = "^\\d+(\\.\\d+)?";

    @Override
    public boolean supports(Class<?> aClass) {
        return Food.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace( errors,"fats", "fats.error", "This field should contain a number");

        Food food = (Food) o;

        if (food.getFats() != null) {
            pattern = Pattern.compile(DOUBLE_PATTERN);
            matcher = pattern.matcher(food.getFats().toString());

            if (!matcher.matches()) {
                errors.rejectValue("fats", "incorrect.digit");
            }
        }

    }
}
