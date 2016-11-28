package com.LabaLaba.model;

/**
 * Created by rien on 11/28/16.
 */
public class UserRegistrationForm {

    private String username;

//    @Email
//    @NotEmpty
    private String email;

//    @NotEmpty
    private String password;

//    @NotEmpty
    private String repeatPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
