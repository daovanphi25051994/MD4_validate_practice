package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IUserService userService;

    @GetMapping()
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/user/save")
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("result");
        userService.save(user);
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }
}