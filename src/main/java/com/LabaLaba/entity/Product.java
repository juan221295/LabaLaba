package com.LabaLaba.entity;

import javax.persistence.*;

/**
 * Created by rien on 11/28/16.
 */
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Category category;
    private Long price;
    private String path;
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
