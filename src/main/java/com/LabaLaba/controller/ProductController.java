package com.LabaLaba.controller;

import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.RegisterProductForm;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.service.SupplierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by rien on 12/6/16.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity uploadNewProduct(HttpSession session,
                                           @RequestParam RegisterProductForm form) {
        System.out.println("Here");
        Supplier supplier = null;
        if(!"supplier".equalsIgnoreCase(String.valueOf(session.getAttribute("role")))) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        supplier = (Supplier) session.getAttribute("object");
        Product product = new Product();

        product.setName(form.getName());
        product.setPrice(form.getPrice());

        product.setSupplier(supplier);

        productService.addNewProduct(product);

        return new ResponseEntity(HttpStatus.OK);
    }
}
