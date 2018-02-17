package com.jay.calories_calculator.controllers;

import com.jay.calories_calculator.model.domain.CalendarUnit;
import com.jay.calories_calculator.model.domain.User;
import com.jay.calories_calculator.model.service.CalendarUnitService;
import com.jay.calories_calculator.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    private CalendarUnitService calendarUnitService;

    @Autowired
    public UserController(UserService userService, CalendarUnitService calendarUnitService) {
        this.userService = userService;
        this.calendarUnitService = calendarUnitService;
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
    public ModelAndView userPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("user/userpage");

        User user = userService.findUserById(id);

        List<CalendarUnit> calendarUnits = calendarUnitService.findByUserId(id);

        modelAndView.addObject("user", user);
        modelAndView.addObject("calendarUnits", calendarUnits);

        return modelAndView;
    }


}
