package com.LabaLaba.controller;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.ProductForm;
import com.LabaLaba.service.*;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by rien on 12/6/16.
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    private final String VIEW_PREFIX = "produk/";

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    public String uploadNewProduct(HttpSession session,
                                   @ModelAttribute("form") ProductForm form) {

        if(session.getAttribute("role").equals("supplier")){
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            Supplier supplier = new Supplier();
            supplier = supplierService.getSupplierById(sessionInfo.getId());
            //supplier.setId(sessionInfo.getId());


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
    public String detailProduk(@RequestParam Long id, Model model, HttpSession session){

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("comments", commentService.findByProduct(productService.getProductById(id)));

        Collection<Product> products =
                productService.getProductByCategoryWithPageRequest(
                        productService.getProductById(id).getCategory(),
                        new PageRequest(0, 3, Sort.Direction.ASC, "uploadDate")).getContent();
        model.addAttribute("relatedProducts", products);

        if(session.getAttribute("user") != null) {
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            model.addAttribute("cart", cartService.getCartByCustomer(sessionInfo.getId()));
        }

        return VIEW_PREFIX + "infoProduk";
    }

    @GetMapping(value = "/delete")
    public String deleteProduct(@RequestParam Long id){
        commentService.deleteCommentByProduct(productService.getProductById(id));
        productService.deleteProduct(id);

        return "redirect:/supplier/profile";
    }

    @GetMapping(value = "/editProduct")
    public String editProduct(@RequestParam Long id, Model model){
        Product product = productService.getProductById(id);

        ProductForm productForm = new ProductForm(product);
        /**Edit Treshold**/
//        ProductForm productForm = new ProductForm();
//        productForm.setId(product.getId());
//        productForm.setDescription(product.getDescription());
//        productForm.setName(product.getName());
//        productForm.setCategory(product.getCategory());
//        productForm.setSupplier(product.getSupplier());
//
//        Map<Long, Long> tresholds = product.getTresholds();
//        List<Long> tresholdQuantity = new ArrayList(tresholds.keySet());
//
//        productForm.setTreshold1(tresholdQuantity.get(0));
//        productForm.setTreshold2(tresholdQuantity.get(1));
//        productForm.setTreshold3(tresholdQuantity.get(2));
//        productForm.setPrice1(tresholds.get(tresholdQuantity.get(0)));
//        productForm.setPrice2(tresholds.get(tresholdQuantity.get(1)));
//        productForm.setPrice3(tresholds.get(tresholdQuantity.get(2)));
        /**EoEdit Treshold**/

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
    public String kategori(@RequestParam String nama,
                           @RequestParam(defaultValue = "1", required = false) int page,
                           Model model,
                           HttpSession session){
        if(page < 1) {
            page = 1;
        }

        Page<Product> productPage =
                productService.getProductByCategoryWithPageRequest(
                        Category.valueOf(nama),
                        new PageRequest(page - 1, 10, Sort.Direction.ASC, "uploadDate")
                );

        if(session.getAttribute("user") != null) {
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            model.addAttribute("cart", cartService.getCartByCustomer(sessionInfo.getId()));
        }
        model.addAttribute("productPage", productPage);
        model.addAttribute("namaKategori", nama);
        return VIEW_PREFIX +"kategori";

    }

    @RequestMapping(method = RequestMethod.POST, value = "comment")
    public String addComment(@RequestParam String text, @RequestParam String id, HttpSession session){
        try{
            if(session.getAttribute("role").equals("customer")){

                Long idBarang = Long.parseLong(id);
                SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");

                commentService.addComment(text, customerService.getUserById(sessionInfo.getId()), productService.getProductById(idBarang));

                return "redirect:/products/detail?id=" + id;
            }
        }catch (Exception e){
            return "redirect:/customer/login";
        }
        return "redirect:/customer/login";

    }


    @RequestMapping(method = RequestMethod.GET, value = "search")
    public String search(@RequestParam String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         Model model,
                         HttpSession session){
        if(page <= 0) {
            page = 1;
        }
        Page<Product> searchResult = productService.searchProduct(keyword, new PageRequest(page - 1, 10, Sort.Direction.ASC, "uploadDate"));

        if(session.getAttribute("user") != null) {
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            model.addAttribute("cart", cartService.getCartByCustomer(sessionInfo.getId()));
        }
        model.addAttribute("products", searchResult);

        model.addAttribute("keyword", keyword);
        return VIEW_PREFIX + "searchResult";
    }
}
