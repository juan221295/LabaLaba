package com.LabaLaba.entity;

import com.LabaLaba.form.CustomerRegistrationForm;

import javax.persistence.*;

/**
 * Created by rien on 11/5/16.
 */

@Entity
@Table(name = "users")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String email;
    private String password;


    public Customer() {}

    public Customer(CustomerRegistrationForm form) {
        this.name = form.getName();
        this.email = form.getEmail();
        this.password = form.getPassword();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
