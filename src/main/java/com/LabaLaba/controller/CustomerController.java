package com.LabaLaba.controller;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.form.CustomerRegistrationForm;
import com.LabaLaba.service.CustomerService;
import com.LabaLaba.validator.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    private CustomerService service;

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

        service.register(registrationForm);
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
        if(service.login(email, password).isPresent()) {

//            session.setAttribute("username", );
//            CustomerService cs = new CustomerService();

            session.setAttribute("loggedIn", true);
//            session.setAttribute("username", service.getUserByEmail(email).getName());
//            session.setAttribute("username", service.getUserByEmail(email).getName());
            session.setAttribute("customer", service.getUserByEmail(email));
            System.out.println("login success");
            System.out.println(service.getUserByEmail(email).getName());
            return "redirect:/";
        }

        return "redirect:/customer/login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
//        if(service.login(email, password).isPresent()) {
//
////            session.setAttribute("username", );
////            CustomerService cs = new CustomerService();
//
//            session.setAttribute("loggedIn", true);
////            session.setAttribute("username", service.getUserByEmail(email).getName());
//            session.setAttribute("user", service.getUserByEmail(email));
//            System.out.println("login success");
//            System.out.println(service.getUserByEmail(email).getName());
//            //return "redirect:/";
//
//            mav.addObject("nama", service.getUserByEmail(email).getName());
//
//            return mav;
//        }
//
//        return new ModelAndView("forward:/customer/login");
//    }

    @RequestMapping(value = "/logout")
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
        return service.getAllUser();
    }

    @RequestMapping("/clear")
    public void clearUser(){
        service.clearUser();
    }
}
