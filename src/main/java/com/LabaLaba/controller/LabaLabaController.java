package com.LabaLaba.controller;

import com.LabaLaba.entity.Product;
import com.LabaLaba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Controller
public class LabaLabaController {
    @Autowired
    private ProductService productService;

	@RequestMapping("/")
	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        ArrayList<Product> products = (ArrayList)productService.getAll();
        Collections.sort(products, (product1, product2) -> product2.getId().compareTo(product1.getId()));

        Map<String, List<Product>> displayItem = productService.getProductOnIndexPage();

        model.addAttribute("name", "index");
        model.addAttribute("products", products);
        model.addAttribute("displayItems", displayItem);

	    return "index";
	}

    @RequestMapping("/error123")
    public String error(){
        return "error";
    }
}