package com.LabaLaba.entity;

import javax.persistence.*;
import java.util.Map;

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
    /**Edit Treshold**/
    private Long price;
    /**EoEdit Treshold**/

    public CartItem() {}

    public CartItem(Customer owner, Product product, Integer quantity) {
        this.owner = owner;
        this.product = product;
        this.quantity = quantity;

        /**Edit Treshold**/
        Map<Long, Long> productTreshold = product.getTresholds();

        for(Map.Entry<Long, Long> treshold : productTreshold.entrySet()) {
            if(this.quantity >= treshold.getKey()) {
                this.price = treshold.getValue();
            }
        }
        /**EoEdit Treshold**/
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
