package com.jay.calories_calculator.controllers;

import com.jay.calories_calculator.model.domain.Food;
import com.jay.calories_calculator.model.domain.User;
import com.jay.calories_calculator.model.service.api.FoodService;
import com.jay.calories_calculator.model.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminController {

    private UserService userService;

    private FoodService foodService;

    @Autowired
    public AdminController(UserService userService, FoodService foodService) {
        this.userService = userService;
        this.foodService = foodService;
    }



    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView("admin/home");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User admin = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("adminName", admin.getName());

        modelAndView.addObject("adminMessage",
                "Content Available Only for Users with Admin Role");

        return modelAndView;
    }

    @RequestMapping(value = "/admin/userList", method = RequestMethod.GET)
    public ModelAndView userList() {

        ModelAndView modelAndView = new ModelAndView("admin/userList");

        modelAndView.addObject("users", userService.findAllUsers());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User admin = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("adminName", admin.getName());

        return modelAndView;
    }

    @RequestMapping(value = "/admin/foodpage", method = RequestMethod.GET)
    public ModelAndView foodPage() {
        ModelAndView modelAndView = new ModelAndView("admin/foodpage");
        modelAndView.addObject("food", new Food());

        modelAndView.addObject("foodList", foodService.findAllFood());

        return modelAndView;
    }

    @RequestMapping(value = "/admin/foodpage", method = RequestMethod.POST)
    public ModelAndView saveFood(@Valid Food food, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("admin/foodpage");

        Food existedFood = foodService.findFoodByName(food.getName());

        if (existedFood != null) {
                bindingResult.rejectValue("name", "error.food", "There is already a food with such name");
        }

        if (!bindingResult.hasErrors()) {
            foodService.saveFood(food);
            modelAndView.addObject("successMessage", "New food data has been saved");
        }

                modelAndView.addObject("foodList", foodService.findAllFood());

        return modelAndView;
    }


}
