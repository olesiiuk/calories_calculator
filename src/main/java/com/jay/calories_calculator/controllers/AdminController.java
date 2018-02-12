package com.jay.calories_calculator.controllers;

import com.jay.calories_calculator.model.domain.User;
import com.jay.calories_calculator.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "admin/home", method = RequestMethod.GET)
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView("admin/home");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User admin = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("adminName", admin.getName());

        modelAndView.addObject("adminMessage",
                "Content Available Only for Users with Admin Role");

        return modelAndView;
    }

    @RequestMapping(value = "admin/userList", method = RequestMethod.GET)
    public ModelAndView userList() {

        ModelAndView modelAndView = new ModelAndView("admin/userList");

        modelAndView.addObject("users", userService.findAllUsers());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User admin = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("adminName", admin.getName());

        return modelAndView;
    }





}
