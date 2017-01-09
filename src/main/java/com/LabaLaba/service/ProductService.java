package com.LabaLaba.service;

import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.ProductForm;
import com.LabaLaba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by rien on 12/6/16.
 */
@Service
public class ProductService {
    public static final String IMAGE_DIR = System.getProperty("user.dir") + "/src/main/resources/static/images/";

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(ProductForm form) {
        Product product = new Product(form);

        System.out.println(form.getCategory());
        if(form.getId()!=null) {
            product.setId(product.getId());
        }

        Product result = productRepository.save(product);

        if(form.getFile()==null) {
            return result;
        }
        String imagePath = this.uploadImage(form.getFile(), product);
        product.setImagePath(imagePath);

        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Collection<Product> getAll(){
        return productRepository.findAll();
    }

    public Collection<Product> getBySupplier(Long id){
        return productRepository.findBySupplier_Id(id);
    }

    public Collection<Product> getBySupplier(Supplier supplier){
        return productRepository.findBySupplier(supplier);
    }

    public String uploadImage(MultipartFile uploadingFile, Product product){
        String namaFile = product.getId().toString()+ "-" +uploadingFile.getOriginalFilename();

        System.out.println(IMAGE_DIR);
        try {
            Files.createDirectories(Paths.get(IMAGE_DIR));
            File file = new File(IMAGE_DIR + namaFile);
            uploadingFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        return namaFile;
    }

    public void deleteProduct(Long id){
        productRepository.delete(id);
    }

    public void editProduct(ProductForm form){
        Product oldProduct = getProductById(form.getId());
        oldProduct.setDescription(form.getDescription());
        oldProduct.setMinimalQuantity(form.getMinimalQuantity());
        oldProduct.setPrice(form.getPrice());
        productRepository.save(oldProduct);
    }

}
