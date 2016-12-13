package com.LabaLaba.controller;

import com.LabaLaba.entity.Cart;
import com.LabaLaba.entity.Product;
import com.LabaLaba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@Controller
public class LabaLabaController {
    @Autowired
    private ProductService productService;

	@RequestMapping("/")
	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {


        ArrayList<Product> products = (ArrayList)productService.getAll();
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });

        model.addAttribute("name", "index");
        model.addAttribute("products", products);

	    return "index";
	}

	@RequestMapping("/error123")
    public String error(){
        return "error";
    }

    /*====EXPERIMENTAL ARENA ====*/
	//sketch below(unchecked)
	@RequestMapping(value = "/cart", method = RequestMethod.PUT)
    public void addToCart(@RequestParam Product product, HttpSession session) {
        if(session.getAttribute("cart")==null) {
            session.setAttribute("cart", new Cart());
        }

        Cart cart = (Cart)session.getAttribute("cart");
        cart.addProduct(product);
    }


}