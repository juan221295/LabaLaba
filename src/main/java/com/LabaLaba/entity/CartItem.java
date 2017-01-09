package com.LabaLaba.entity;

import javax.persistence.*;

/**
 * Created by rien on 12/25/16.
 */
@Entity
@Table(name = "carts")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Customer owner;
    @ManyToOne
    private Product product;
    private Integer quantity;

    public CartItem() {}

    public CartItem(Customer owner, Product product, Integer quantity) {
        this.owner = owner;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
