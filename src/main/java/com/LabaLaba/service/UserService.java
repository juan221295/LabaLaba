package com.LabaLaba.service;

import com.LabaLaba.model.User;
import com.LabaLaba.model.UserRegistrationForm;
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

    public void registerUser(UserRegistrationForm registrationForm) {
        User user = new User();
        user.setUsername(registrationForm.getUsername());
        user.setPassword(registrationForm.getPassword());
        user.setEmail(registrationForm.getEmail());

        repository.save(user);
    }

    public void clearUser(){
        repository.deleteAll();
    }
}
