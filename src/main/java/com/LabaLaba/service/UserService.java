package com.LabaLaba.service;

import com.LabaLaba.entity.User;
import com.LabaLaba.form.UserRegistrationForm;
import com.LabaLaba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by rien on 11/28/16.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Collection<User> getAllUser() {
        return (Collection<User>) repository.findAll();
    }

    public void register(UserRegistrationForm registrationForm) {
        User user = new User();
        user.setName(registrationForm.getName());
        user.setPassword(registrationForm.getPassword());
        user.setEmail(registrationForm.getEmail());

        repository.save(user);
    }

    public void clearUser(){
        repository.deleteAll();
    }
}
