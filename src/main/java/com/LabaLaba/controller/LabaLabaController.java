package com.LabaLaba.controller;

import com.LabaLaba.entity.Cart;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.RegisterProductForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class LabaLabaController {
//	@RequestMapping("/")
//	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//
//
//	    model.addAttribute("name", "index");
//	    return "index";
//	}

    /*====EXPERIMENTAL ARENA ====*/

    @RequestMapping("/")
    public String getIndex(HttpSession session, Model model) {
        model.addAttribute("form", new RegisterProductForm());
        session.setAttribute("role", "supplier");
        Supplier supplier = new Supplier();
        supplier.setSupplierId(Long.valueOf(1));
        session.setAttribute("object", supplier);
        return "scratch";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Product> getSomething() {
        Product product = new Product();

        product.setId(Long.valueOf(1));
        product.setName("WHAHAHAHAH");
        product.setPrice(Long.valueOf(10000));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

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