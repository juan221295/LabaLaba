package com.LabaLaba.controller;

import com.LabaLaba.model.User;
import com.LabaLaba.model.UserRegistrationForm;
import com.LabaLaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by rien on 11/28/16.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("form", new UserRegistrationForm());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegister(@ModelAttribute(name = "form") UserRegistrationForm registrationForm) {

            System.out.println(registrationForm.getEmail());
            System.out.println(registrationForm.getUsername());
            System.out.print(registrationForm.getPassword());
            System.out.println(registrationForm.getRepeatPassword());

        service.registerUser(registrationForm);
            return "register";

    }

    @ResponseBody
    @RequestMapping("/all")
    public Collection<User> getAllUser() {
        return service.getAllUser();
    }
}
