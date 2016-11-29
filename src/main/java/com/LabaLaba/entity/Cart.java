package com.LabaLaba.entity;

import java.util.Collection;

/**
 * Created by rien on 11/29/16.
 */
public class Cart {
    private Collection<Product> products;

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
