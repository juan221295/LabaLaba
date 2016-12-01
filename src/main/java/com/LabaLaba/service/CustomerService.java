package com.LabaLaba.service;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.form.CustomerRegistrationForm;
import com.LabaLaba.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by rien on 11/28/16.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getUserByEmail(String email) {
        return repository.findOneByEmail(email);
    }

    public Optional<Customer> login(String email, String password) {
        Customer customer = repository.findOneByEmail(email);

        if(customer ==null) {
            return null;
        }


        if(password.equals(customer.getPassword())) {
            return Optional.ofNullable(customer);
        } else {
            return null;
        }
    }

    public Collection<Customer> getAllUser() {
        return (Collection<Customer>) repository.findAll();
    }

    public void register(CustomerRegistrationForm registrationForm) {
        Customer customer = new Customer();
        customer.setName(registrationForm.getName());
        customer.setPassword(registrationForm.getPassword());
        customer.setEmail(registrationForm.getEmail());

        repository.save(customer);
    }

    public void clearUser(){
        repository.deleteAll();
    }
}
