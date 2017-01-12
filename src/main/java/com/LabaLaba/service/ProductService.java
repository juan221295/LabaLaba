package com.LabaLaba.service;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.ProductForm;
import com.LabaLaba.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String imagePath = this.uploadImage(form.getFile(), result);
        result.setImagePath(imagePath);

        return productRepository.save(result);
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
//            File file = new File(IMAGE_DIR+ idSupp.toString() + "/" + namaFile);
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

    public Map<String, List<Product>> getProductOnIndexPage() {
        Map<String, List<Product>> result = new HashMap<>();
        for(Category category : Category.values()) {
            List<Product> products =
                    productRepository.findByCategory(category, new PageRequest(0, 5, Sort.Direction.ASC, "uploadDate")).getContent();

            result.put(category.name(), products);
        }
        return result;
    }

    public Page<Product> getProductByCategoryWithPageRequest(Category category, PageRequest pageRequest) {
        return productRepository.findByCategory(category, pageRequest);
    }

    public Collection<Product> searchProduct(String keyword){
//        Collection<Product> products = productRepository.findByModelContainingWithIgnoreCase(keyword);
////                productRepository.findByModelStartingWithIgnoreCase(keyword);
//        products.addAll(productRepository.findByModelStartingWithIgnoreCase(keyword));
//        products.addAll(productRepository.findByModelEndingWithIgnoreCase(keyword));


        //return products;

        return productRepository.findByKeyWord(keyword);

    }


}
