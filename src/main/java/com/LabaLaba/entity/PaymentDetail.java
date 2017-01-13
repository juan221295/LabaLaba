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
    private Long productId;
    private String productName;
    private String productImagePath;
    @ManyToOne
    private Payment header;
    private Integer quantity;
    private Long price;

    public PaymentDetail(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
