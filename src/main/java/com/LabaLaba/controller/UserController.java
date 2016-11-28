package com.LabaLaba.controller;

import com.LabaLaba.entity.User;
import com.LabaLaba.form.UserRegistrationForm;
import com.LabaLaba.service.UserService;
import com.LabaLaba.validator.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by rien on 11/28/16.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private final String VIEW_PREFIX = "user/";

    @Autowired
    private UserService service;

    @Autowired
    private UserRegistrationFormValidator validator;

    @InitBinder("form")
    public void initBinder (WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("form", new UserRegistrationForm());
        return VIEW_PREFIX + "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegister(@Valid @ModelAttribute(name = "form") UserRegistrationForm registrationForm, BindingResult bindingResult) {


        if(bindingResult.hasErrors()) {
            return VIEW_PREFIX + "register";
        }

        service.register(registrationForm);
        return VIEW_PREFIX + "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return VIEW_PREFIX + "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        return "/";
    }

    //RESPONSE BODY FOR TESTING BELOW

    @ResponseBody
    @RequestMapping("/all")
    public Collection<User> getAllUser() {
        return service.getAllUser();
    }

    @RequestMapping("/clear")
    public void clearUser(){
        service.clearUser();
    }
}
