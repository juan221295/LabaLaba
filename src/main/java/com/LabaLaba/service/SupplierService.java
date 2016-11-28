package com.LabaLaba.service;

import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.SupplierRegistrationForm;
import com.LabaLaba.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rien on 11/28/16.
 */
@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository;


    public void register(SupplierRegistrationForm registrationForm) {
        Supplier supplier = new Supplier();

        supplier.setEmail(registrationForm.getEmail());
        supplier.setName(registrationForm.getName());
        supplier.setPassword(registrationForm.getPassword());

        if(!registrationForm.getWebsite().isEmpty()) {
            supplier.setWebsite(registrationForm.getWebsite());
        }

        repository.save(supplier);
    }
}
