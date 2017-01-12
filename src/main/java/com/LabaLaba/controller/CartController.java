package com.LabaLaba.controller;

import com.LabaLaba.service.CartService;
import com.LabaLaba.service.CustomerService;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam Integer quantity,
                            HttpSession session,
                            HttpServletRequest request,
                            Model model) {

        try{
            if(session.getAttribute("role").equals("customer")){
                SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
                if(new Long(quantity) >= productService.getProductById(productId).getMinimalQuantity()){
                    cartService.addToCart(sessionInfo.getId(), productId, quantity);
                    return "redirect:" + getRefererUrl(request);
                }else{
                    model.addAttribute("link", getRefererUrl(request));
                    return "fail";
                }
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

    @GetMapping(value = "/checkout")
    private String checkOut(HttpSession session, Model model){
        try {
            if(session.getAttribute("role").equals("customer")) {
                SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
                model.addAttribute("cart", cartService.getCartByCustomer(sessionInfo.getId()));
                model.addAttribute("customer", customerService.getUserById(sessionInfo.getId()));

                return "customer/checkout";
            }
            else{
                return "redirect:/";
            }
        }catch (NullPointerException e){
            return "redirect:/";
        }

    }
}
