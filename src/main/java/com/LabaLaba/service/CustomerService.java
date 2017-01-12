package com.LabaLaba.service;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.form.CustomerRegistrationForm;
import com.LabaLaba.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by rien on 11/28/16.
 */
@Service
public class CustomerService {
    public static final String IMAGE_DIR = System.getProperty("user.dir") + "/src/main/resources/static/images/";

    @Autowired
    private CustomerRepository repository;

    public Customer getUserByEmail(String email) {
        return repository.findOneByEmail(email);
    }
    public Customer getUserById(Long id){
        return repository.findById(id);
    }

    public Customer login(String email, String password) {
        Customer customer = repository.findOneByEmailAndPassword(email, password);
//        if(customer ==null) {
//            return null;
//        }
//
//
//        if(password.equals(customer.getPassword())) {
//            return Optional.ofNullable(customer);
//        } else {
//            return null;
//        }
        return customer;
    }

    public void register(CustomerRegistrationForm registrationForm) {
        Customer customer = new Customer(registrationForm);
        repository.save(customer);
    }

    public Collection<Customer> getAllUser() {
        return (Collection<Customer>) repository.findAll();
    }
    public void clearUser(){
        repository.deleteAll();
    }

    public void deleteCustomer(Long id){
        repository.delete(id);
    }
    public void editProfile(CustomerRegistrationForm form){
        Customer oldCustomer =getUserByEmail(form.getEmail());
        oldCustomer.setName(form.getName());
        oldCustomer.setEmail(form.getEmail());
        oldCustomer.setPassword(form.getPassword());
        if(!form.getPhotoProfile().isEmpty()){
            oldCustomer.setImagePath(this.uploadImage(form.getPhotoProfile(), oldCustomer));
        }

        repository.save(oldCustomer);
//        Product oldProduct = getProductById(form.getId());
//        oldProduct.setDescription(form.getDescription());
//        oldProduct.setMinimalQuantity(form.getMinimalQuantity());
//        oldProduct.setPrice(form.getPrice());
//        productRepository.save(oldProduct);

    }

    public String uploadImage(MultipartFile uploadingFile, Customer customer){
        String namaFile = customer.getId().toString()+ "-" + customer.getName();

        System.out.println(IMAGE_DIR);
        try {
            Files.createDirectories(Paths.get(IMAGE_DIR));
//            File file = new File(IMAGE_DIR+ idSupp.toString() + "/" + namaFile);
            File file = new File(IMAGE_DIR + namaFile);
            uploadingFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        return namaFile;
    }

}
