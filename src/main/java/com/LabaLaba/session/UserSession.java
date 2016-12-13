package com.LabaLaba.session;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.entity.Supplier;

/**
 * Created by Juan on 12/13/16.
 */
public class UserSession {
    private Long id;
    private String name;
    private String email;

    public UserSession(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public  UserSession(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }
    public  UserSession(Supplier supplier){
        this.id = supplier.getSupplierId();
        this.name = supplier.getName();
        this.email = supplier.getEmail();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
