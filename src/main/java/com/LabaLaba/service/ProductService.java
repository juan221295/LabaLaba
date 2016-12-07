package com.LabaLaba.service;

import com.LabaLaba.entity.Product;
import com.LabaLaba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rien on 12/6/16.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }
}
