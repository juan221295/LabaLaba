package com.LabaLaba.controller;

import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.RegisterProductForm;
import com.LabaLaba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by rien on 12/6/16.
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    private final String VIEW_PREFIX = "produk/";

    @Autowired
    private ProductService productService;

    public static final String IMAGE_DIR = System.getProperty("user.dir") + "/src/main/resources/static/images/";


    @RequestMapping(method = RequestMethod.POST)
    public String uploadNewProduct(HttpSession session,
                                   @ModelAttribute("form") RegisterProductForm form) {

        if(session.getAttribute("role").equals("supplier")){
            Supplier supplier = (Supplier) session.getAttribute("user");
            Product product = new Product();
            product.setSupplier(supplier);
            product.setName(form.getName());
            product.setPrice(form.getPrice());

            productService.addOrUpdateProduct(product);

            product.setImagePath(upload(form.getFile(), product));

            productService.addOrUpdateProduct(product);

            return "redirect:/products/success";
        }
        return "redirect:/error123";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("form", new RegisterProductForm());

        return "add-product";
    }


    public String upload(MultipartFile uploadingFile, Product product){
        String namaFile = product.getId().toString()+ "-" +uploadingFile.getOriginalFilename();
        File file = new File(IMAGE_DIR + namaFile);
        try {
            uploadingFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        return namaFile;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/success")
    public String success(Model model, HttpSession session){

        Supplier supplier = (Supplier) session.getAttribute("user");
        model.addAttribute("products", productService.getBySupplier(supplier));
//       model.addAttribute("products", productService.getBySupplier((long)supplier.getSupplierId()));
//        model.addAttribute("produk", productService.getProductById((long) session.getAttribute("supId"))); //ini masih statis

        return "success";
    }

    @RequestMapping(value="/infoProduk", method = RequestMethod.GET)
    public String infoProduk(){

        return VIEW_PREFIX + "infoProduk";
    }


}
