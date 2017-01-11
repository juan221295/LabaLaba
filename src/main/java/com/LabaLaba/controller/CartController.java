package com.LabaLaba.controller;

import com.LabaLaba.service.CartService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by rien on 12/17/16.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam Integer quantity,
                            HttpSession session,
                            HttpServletRequest request) {

        try{
            if(session.getAttribute("role").equals("customer")){
                SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
                System.out.println(productId);
                System.out.println(quantity);
                System.out.println(sessionInfo.getId());
                cartService.addToCart(sessionInfo.getId(), productId, quantity);
                System.out.println(getRefererUrl(request));
                return "redirect:" + getRefererUrl(request);
            }else{
                return "redirect:" + getRefererUrl(request);
            }
        }catch (NullPointerException e){
            return "redirect:" + getRefererUrl(request);
        }



    }

    @PostMapping("/delete")
    public String deleteFromCart(@RequestParam Long cartItemId,
                                 HttpServletRequest request) {

        cartService.deleteFromCart(cartItemId);

        return "redirect:" + getRefererUrl(request);
    }

    private String getRefererUrl(HttpServletRequest request) {
        return request.getHeader("Referer");
    }
}
