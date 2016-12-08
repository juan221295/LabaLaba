package com.LabaLaba.service;

import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

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

    public Collection<Product> getAll(){
        return productRepository.findAll();
    }

    public Collection<Product> getBySupplier(Long id){
        return productRepository.findBySupplier_SupplierId(id);

    }

    public Collection<Product> getBySuplier(Supplier supplier){
        return productRepository.findBySupplier(supplier);
    }

}
