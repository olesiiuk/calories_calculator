package com.jay.calories_calculator.controllers;


import com.jay.calories_calculator.model.domain.Role;
import com.jay.calories_calculator.model.domain.User;
import com.jay.calories_calculator.model.service.RoleService;
import com.jay.calories_calculator.model.service.UserService;
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
public class LoginController {

    private UserService userService;

    private RoleService roleService;


    @Autowired
    public LoginController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/successlogin", method = RequestMethod.GET)
    public ModelAndView successLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = userService.findUserByEmail(auth.getName());
        Role adminRole = roleService.findByRoleName("ADMIN");

        if (currentUser.getAuthorities().contains(adminRole)) {
            modelAndView.setViewName("redirect:/admin/home");
        } else {
            modelAndView.setViewName("redirect:/user/" + currentUser.getId());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello() {

        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView model = new ModelAndView("registration");
        model.addObject("user", new User());

        return model;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user",
                    "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
