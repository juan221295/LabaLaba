package com.LabaLaba.controller;

import com.LabaLaba.entity.Product;
import com.LabaLaba.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


/**
 * Created by rien on 12/17/16.
 */
@RestController("/cart")
public class CartController {
    @Autowired
    private PaymentService paymentService;

    @PutMapping
    public ResponseEntity addToCart(HttpSession session,
                                    @RequestParam Long productId,
                                    @RequestParam Integer quantity) {
        HashMap cart = (HashMap) session.getAttribute("cart");
        if(null == cart) {
            session.setAttribute("cart", new HashMap());
        }

        Product product = new Product(productId);

        cart.put(product, quantity);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity removeProductFromCart(HttpSession session,
                                                @RequestParam Long productId) {
        HashMap cart = (HashMap) session.getAttribute("cart");
        if(null == cart) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Product product = new Product(productId);

        cart.remove(product);
        return new ResponseEntity(HttpStatus.OK);
    }

//    public boolean processCart(HttpSession session) {
//        HashMap cart = (HashMap) session.getAttribute("cart");
//        if(null == cart) {
//            return null;
//        }
//
//        UserSession userSession = (UserSession) session.getAttribute("user");
//
//        paymentService.createPayment(cart, userSession);
//
//    }
}
