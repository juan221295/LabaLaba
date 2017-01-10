package com.LabaLaba.controller;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.ProductForm;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam Long id){

        productService.deleteProduct(id);
        return "redirect:/supplier/profile";
    }

    @GetMapping(value = "/editProduct")
    public String editProduct(@RequestParam Long id, Model model){
        Product product = productService.getProductById(id);

        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setName(product.getName());
        productForm.setCategory(product.getCategory());
        productForm.setPrice(product.getPrice());
        productForm.setMinimalQuantity(product.getMinimalQuantity());
        productForm.setSupplier(product.getSupplier());


        model.addAttribute("form", productForm);
        model.addAttribute("product", product);
        return VIEW_PREFIX + "editProduct";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String editProcess(@ModelAttribute("form") ProductForm form){

        productService.editProduct(form);
        return "redirect:/supplier/profile";
    }

    @GetMapping(value = "/kategori")
    public String kategori(@RequestParam String nama, Model model){
        List<Product> products = productService.getProductByCategoryWithPageRequest(Category.valueOf(nama), new PageRequest(0, 10, Sort.Direction.ASC, "uploadDate")).getContent();

        model.addAttribute("products", products);
        model.addAttribute("namaKategori", nama);
        return VIEW_PREFIX +"kategori";

    }






}
