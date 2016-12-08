package com.LabaLaba.controller;

import com.LabaLaba.form.SupplierRegistrationForm;
import com.LabaLaba.form.CustomerRegistrationForm;
import com.LabaLaba.service.SupplierService;
import com.LabaLaba.validator.SupplierRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by rien on 11/28/16.
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    private final String VIEW_PREFIX = "supplier/";

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierRegistrationFormValidator validator;

    @InitBinder("form")
    public void initBinder (WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("form", new SupplierRegistrationForm());
        return VIEW_PREFIX + "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
      public String handleRegister(@Valid @ModelAttribute(name = "form") SupplierRegistrationForm registrationForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return VIEW_PREFIX + "register";
        }

        supplierService.register(registrationForm);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return VIEW_PREFIX + "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        return "/";
    }
}
