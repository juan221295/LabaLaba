package com.LabaLaba.entity;

import com.LabaLaba.form.SupplierRegistrationForm;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by rien on 11/28/16.
 */
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String email;
    private String name;
    private String website;
    private String password;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "supplier")
    private Collection<Product> products;

    public Supplier() {}

    public Supplier(SupplierRegistrationForm  form) {
        this.setEmail(form.getEmail());
        this.setName(form.getName());
        this.setPassword(form.getPassword());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
