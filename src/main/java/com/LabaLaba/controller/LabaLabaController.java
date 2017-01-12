package com.LabaLaba.controller;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.service.CartService;
import com.LabaLaba.service.ProductService;
import com.LabaLaba.session.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LabaLabaController {
    private final Integer INDEX_ITEM_PAGE_SIZE = 4;
    private final Integer FIRST_PAGE = 0;

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request, HttpSession session) {

        Map<String, List<Product>> displayItem = new HashMap<>();
        for(Category category : Category.values()) {
            List<Product> products =
                    productService.getProductByCategoryWithPageRequest(
                            category,
                            new PageRequest(FIRST_PAGE, INDEX_ITEM_PAGE_SIZE, Sort.Direction.ASC, "uploadDate")).getContent();

            displayItem.put(category.name(), products);
        }

        if(session.getAttribute("user") != null) {
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("user");
            model.addAttribute("cart", cartService.getCartByCustomer(sessionInfo.getId()));
        }

        model.addAttribute("displayItems", displayItem);

	    return "index";
	}

}