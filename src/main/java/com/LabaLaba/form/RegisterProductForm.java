package com.LabaLaba.form;

/**
 * Created by rien on 12/6/16.
 */
public class RegisterProductForm {
    private String name;
    private long price;
    private long minimalQuantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(long minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }
}
