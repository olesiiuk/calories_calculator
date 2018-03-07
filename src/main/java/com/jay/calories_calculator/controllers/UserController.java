package com.jay.calories_calculator.controllers;

import com.jay.calories_calculator.model.domain.SumObject;
import com.jay.calories_calculator.model.handlers.CalculationHandler;
import com.jay.calories_calculator.model.handlers.DateAndTimeHandler;
import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.domain.User;
import com.jay.calories_calculator.model.service.api.CalendarUnitService;
import com.jay.calories_calculator.model.service.api.FoodService;
import com.jay.calories_calculator.model.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    private CalendarUnitService calendarUnitService;

    private FoodService foodService;

    private CalculationHandler calculationHandler;

    @Autowired
    public UserController(UserService userService, CalendarUnitService calendarUnitService, FoodService foodService,
                          CalculationHandler calculationHandler) {
        this.calculationHandler = calculationHandler;
        this.userService = userService;
        this.calendarUnitService = calendarUnitService;
        this.foodService = foodService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView blankUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        ModelAndView modelAndView = new ModelAndView("redirect:/user/" + user.getId());

//        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView userPage(@PathVariable Long id,
                                 @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        ModelAndView modelAndView = new ModelAndView("user/userpage");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (!user.getId().equals(id)) {
            modelAndView.setViewName("403");
            return modelAndView;
        }

        LocalDate nowDate;

        if (date != null) {
            nowDate = date;
        } else {
            nowDate = LocalDate.now();
        }

        List<CalendarUnit> calendarUnits = calendarUnitService.findByUserIdAndDate(id, nowDate);

        SumObject sum = calculationHandler.calculateSum(calendarUnits);

        modelAndView.addObject("nowDate", nowDate);
        modelAndView.addObject("sum", sum);
        modelAndView.addObject("user", user);
        modelAndView.addObject("calendarUnits", calendarUnits);

        return modelAndView;
    }

    @RequestMapping(value = "/user/{id}/foodlist", method = RequestMethod.GET)
    public ModelAndView foodList(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("user/foodList");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (!user.getId().equals(id)) {
            modelAndView.setViewName("403");
            return modelAndView;
        }

//        List<Food> customFoodList =

        modelAndView.addObject("hours", DateAndTimeHandler.getHours());
        modelAndView.addObject("nowDate", DateAndTimeHandler.getNowDate());
        modelAndView.addObject("nowTime", DateAndTimeHandler.getNowTime());

        modelAndView.addObject("user", userService.findUserById(id));
        modelAndView.addObject("calendarUnit", new CalendarUnit());
        modelAndView.addObject("foodList", foodService.findAllFood());


        return modelAndView;
    }


    @RequestMapping(value = "/user/{userId}/addfood", method = RequestMethod.POST)
    public ModelAndView addUserFood(@PathVariable Long userId,
                                    @Valid CalendarUnit calendarUnit, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/user/" + userId + "/foodlist");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (!user.getId().equals(userId)) {
            modelAndView.setViewName("403");
            return modelAndView;
        }

        calendarUnit.setFood(foodService.findFoodById(calendarUnit.getFoodId()));
        calendarUnitService.save(calendarUnit);

        return modelAndView;
    }


//    @RequestMapping(value = "/user/{userId}/addfood", method = RequestMethod.POST)
//    public ModelAndView addUsersFood(@PathVariable Long userId,
//                                     @ModelAttribute("foodId") Long foodId,
//                                     @ModelAttribute("time1") @DateTimeFormat(pattern = "HH:mm") LocalTime time,
//                                     @ModelAttribute("date1") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
//                                     @Valid CalendarUnit calendarUnit, BindingResult bindingResult) {
//
//        ModelAndView modelAndView = new ModelAndView("redirect:/user/" + userId + "/foodlist");
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//
//        if (!user.getId().equals(userId)) {
//            modelAndView.setViewName("403");
//            return modelAndView;
//        }
//
//        calendarUnit.setTime(time);
//        calendarUnit.setDate(date);
//        calendarUnit.setFood(foodService.findFoodById(foodId));
//
//        // save calendar unit
//        calendarUnitService.save(calendarUnit);
//
//
//
//        return modelAndView;
//    }
}
