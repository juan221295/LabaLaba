package com.LabaLaba.controller;

import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.SupplierRegistrationForm;
import com.LabaLaba.service.CustomerService;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.service.SupplierService;
import com.LabaLaba.session.SessionInfo;
import com.LabaLaba.validator.SupplierRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    private ProductService productService;

    @Autowired
    private CustomerService customerService;
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
      public String handleRegister(@Valid @ModelAttribute(name = "form") SupplierRegistrationForm registrationForm, BindingResult bindingResult, Model model) {
        if(customerService.getUserByEmail(registrationForm.getEmail()) != null) {
            model.addAttribute("error", "Email sudah dipakai oleh salah satu customer");
            return VIEW_PREFIX + "register";
        }
        if(supplierService.getUserByEmail(registrationForm.getEmail()) != null){
            model.addAttribute("error", "Email sudah dipakai oleh salah satu supplier");
            return VIEW_PREFIX + "register";
        }
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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model, HttpSession session){
        if(session.getAttribute("role").equals("supplier")){
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            Supplier supplier = new Supplier();
            supplier.setId(sessionInfo.getId());
            supplier = supplierService.getSupplierById(sessionInfo.getId());
            model.addAttribute("supplier", supplier);
            model.addAttribute("products", productService.getBySupplier(supplier));
            return VIEW_PREFIX + "supplierProfile";
        }
        return "redirect:/error123";

    }
}
