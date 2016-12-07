package com.LabaLaba.controller;

import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.RegisterProductForm;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.service.SupplierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by rien on 12/6/16.
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    public String uploadNewProduct(HttpSession session,
                                   @ModelAttribute("form") RegisterProductForm form) {

        /**
         * Ceritanya sih buat nahan kalo dia bukan supplier - Ariel
         */
        Supplier supplier = null;
        if(!"supplier".equalsIgnoreCase(String.valueOf(session.getAttribute("role")))) {
            return "redirect:/";
        }

        /**
         * Sejauh ini aku mikirnya Object supplier/customer masukin session, tapi ntah nanti gmn - Ariel
         */
        supplier = (Supplier) session.getAttribute("object");
        Product product = new Product();

        product.setName(form.getName());
        product.setPrice(form.getPrice());

        product.setSupplier(supplier);

        productService.addNewProduct(product);

        return "redirect:/success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("form", new RegisterProductForm());

        return "add-product";
    }
}
