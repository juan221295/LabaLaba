package com.LabaLaba.controller;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Juan on 1/9/17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final String VIEW_PREFIX = "admin/";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CommentService commentService;


    @Autowired
    private ProductService productService;

    @RequestMapping("/dashboard")
    public String adminDashboard(Model model){
        List<Product> products = new ArrayList<>(productService.getAll());
        List<Customer> customers = new ArrayList<>(customerService.getAllUser());
        List<Supplier> suppliers = new ArrayList<>(supplierService.getAllUser());
        Collections.sort(products, (product1, product2) -> product2.getId().compareTo(product1.getId()));
        model.addAttribute("products", products);
        model.addAttribute("customers", customers);
        model.addAttribute("suppliers", suppliers);
        return VIEW_PREFIX + "dashboard";

    }

    @GetMapping("/supplier/delete")
    public String supplierDelete(Model model, @RequestParam Long id){
        Collection<Product> products = productService.getBySupplier(supplierService.getSupplierById(id));
        for (Product product:
             products) {
            commentService.deleteCommentByProduct(product);
            cartService.deleteCartByProduct(product);
            productService.deleteProduct(product.getId());
        }
//        productService.deleteProductBySupplier(supplierService.getSupplierById(id));
        supplierService.deleteSupplier(id);
        return "redirect:/admin/dashboard";

    }

    @GetMapping("/customer/delete")
    public String customerDelete(Model model, @RequestParam Long id){
        customerService.deleteCustomer(id);
        return "redirect:/admin/dashboard";

    }

    @GetMapping("supplier/products")
    public String seeProduct(Model model, @RequestParam Long id){
        Supplier supplier = supplierService.getSupplierById(id);
        model.addAttribute("products", productService.getBySupplier(supplier));
        model.addAttribute("supplier", supplier);

        return VIEW_PREFIX + "supplierProduct";
    }


}
