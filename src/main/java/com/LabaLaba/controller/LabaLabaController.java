package com.LabaLaba.controller;

import com.LabaLaba.entity.Cart;
import com.LabaLaba.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class LabaLabaController {
	@RequestMapping("/")
	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {


	    model.addAttribute("name", "index");
	    return "index";
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