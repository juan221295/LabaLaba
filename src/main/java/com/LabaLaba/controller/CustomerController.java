package com.LabaLaba.controller;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.form.CustomerRegistrationForm;
import com.LabaLaba.service.CustomerService;
import com.LabaLaba.service.SupplierService;
import com.LabaLaba.session.SessionInfo;
import com.LabaLaba.validator.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by rien on 11/28/16.
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final String VIEW_PREFIX = "customer/";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private UserRegistrationFormValidator validator;

    @InitBinder("form")
    public void initBinder (WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("form", new CustomerRegistrationForm());
        return VIEW_PREFIX + "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegister(@Valid @ModelAttribute(name = "form") CustomerRegistrationForm registrationForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return VIEW_PREFIX + "login";
        }

        customerService.register(registrationForm);
        return "redirect:/customer/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(HttpSession session) {
        String login ="redirect:/";
        try{
            if(session.getAttribute("username").equals(null)){

            }

            login = "redirect:/";

        }
        catch (Exception e){
            login = VIEW_PREFIX + "login";
        }

        return login;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        if(customerService.login(email, password) != null) {
            session.setAttribute("loggedIn", true);
            session.setAttribute("role", "customer");

            SessionInfo sessionInfo = new SessionInfo(customerService.getUserByEmail(email));
            session.setAttribute("user", sessionInfo);

            System.out.println("login success");
            System.out.println(customerService.getUserByEmail(email).getName());

            return "redirect:/";
        }else if(supplierService.login(email, password) != null){
            session.setAttribute("loggedIn", true);

            SessionInfo sessionInfo = new SessionInfo(supplierService.getUserByEmail(email));

            session.setAttribute("role", "supplier");
            session.setAttribute("user", sessionInfo);
            session.setAttribute("supId", supplierService.getUserByEmail(email).getId());

            System.out.println("login success");
            System.out.println(supplierService.getUserByEmail(email).getName());
            return "redirect:/";

        }

        return "redirect:/customer/login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout(HttpSession session) {
        session.removeAttribute("loggedIn");
        session.removeAttribute("username");
        session.invalidate();
        return "redirect:/";
    }

    //RESPONSE BODY FOR TESTING BELOW

    @ResponseBody
    @RequestMapping("/all")
    public Collection<Customer> getAllUser() {
        return customerService.getAllUser();
    }

    @RequestMapping("/clear")
    public void clearUser(){
        customerService.clearUser();
    }
}
