package com.LabaLaba.entity;

import javax.persistence.*;

/**
 * Created by rien on 12/25/16.
 */
@Entity
@Table(name = "payment_details")
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Payment header;
    private Integer quantity;
    private Integer price;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getHeader() {
        return header;
    }

    public void setHeader(Payment header) {
        this.header = header;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
