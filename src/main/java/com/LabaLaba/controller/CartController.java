package com.LabaLaba.controller;

import com.LabaLaba.entity.CartItem;
import com.LabaLaba.service.CartService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by rien on 12/17/16.
 */
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /*If needed, I haven't make it yet*/
    @GetMapping
    public String getCartView() {
        return "cart-view";
    }

    @PutMapping
    public String addToCart(@RequestParam Long productId,
                            @RequestParam Integer quantity,
                            @RequestParam String originUrl,
                            HttpSession session) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");

        CartItem item = cartService.addToCart(sessionInfo.getId(), productId, quantity);

        
        return "redirect:"  + originUrl;
    }

    @DeleteMapping
    public String deleteFromCart(@RequestParam Long cartItemId,
                                 @RequestParam String originUrl,
                                 HttpSession session) {

        cartService.deleteFromCart(cartItemId);

        return "redirect:"  + originUrl;
    }
}
