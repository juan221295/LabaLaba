package com.LabaLaba.controller;

import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.ProductForm;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by rien on 12/6/16.
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    private final String VIEW_PREFIX = "produk/";

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public String uploadNewProduct(HttpSession session,
                                   @ModelAttribute("form") ProductForm form) {

        if(session.getAttribute("role").equals("supplier")){
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            Supplier supplier = new Supplier();
            supplier.setId(sessionInfo.getId());

            form.setSupplier(supplier);

            productService.addProduct(form);
            return "redirect:/supplier/profile";
        }
        return "redirect:/error123";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("form", new ProductForm());

        return "add-product";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/success")
    public String success(Model model, HttpSession session){
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
        Supplier supplier = new Supplier();
        supplier.setId(sessionInfo.getId());
        model.addAttribute("products", productService.getBySupplier(supplier));

        return "success";
    }

    @RequestMapping(value="/infoProduk", method = RequestMethod.GET)
    public String infoProduk(){

        return VIEW_PREFIX + "infoProduk";
    }

    @GetMapping(value = "/detail")
    public String detailProduk(@RequestParam Long id, Model model){


        model.addAttribute("product", productService.getProductById(id));
        return VIEW_PREFIX + "infoProduk";
    }


}
