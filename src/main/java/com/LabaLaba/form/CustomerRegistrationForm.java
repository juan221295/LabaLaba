package com.LabaLaba.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rien on 11/28/16.
 */
public class CustomerRegistrationForm {

    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String repeatPassword;

    private MultipartFile photoProfile;

    @NotEmpty
    private String address;

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public MultipartFile getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(MultipartFile photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
