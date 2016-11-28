package com.LabaLaba.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by rien on 11/28/16.
 */
@Entity
public class Supplier {
    @Id
    private Long id;
    private String email;
    private String name;
    private String website;
    private String password;

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
}
