package com.LabaLaba.service;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import com.LabaLaba.form.ProductForm;
import com.LabaLaba.repository.ProductRepository;
import com.LabaLaba.repository.SupplierRepository;
import org.joda.time.DateTime;
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
import java.util.*;

/**
 * Created by rien on 12/6/16.
 */
@Service
public class ProductService {
    public static final String IMAGE_DIR = System.getProperty("user.dir") + "/src/main/resources/static/images/";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

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

    public void editProduct(ProductForm form, Long id){
        Product oldProduct = productRepository.findById(form.getId());

        //Product newProduct = new Product(form);
        oldProduct.setName(form.getName());
//        this.setPrice(form.getPrice());
//        this.setMinimalQuantity(form.getMinimalQuantity());
        oldProduct.setSupplier(supplierRepository.findById(id));
        oldProduct.setUploadDate(new DateTime());
        oldProduct.setCategory(form.getCategory());
        oldProduct.setDescription(form.getDescription());

        /**Edit Treshold**/
        Map<Long, Long> treshold = new TreeMap<>();
        if(form.getTreshold1() <= 0 && form.getPrice1() <=0 &&
                form.getTreshold2() <= 0 && form.getPrice2() <= 0 &&
                form.getTreshold3() <= 0 && form.getPrice3() <= 0)
        {
            treshold.put(new Long(0), new Long(0));
        }
        else{
            if(form.getTreshold1() > 0 || form.getPrice1() >0){
                treshold.put(form.getTreshold1(), form.getPrice1());
            }
            if(form.getTreshold2() > 0 || form.getPrice2() > 0){
                treshold.put(form.getTreshold2(), form.getPrice2());
            }
            if(form.getTreshold3() > 0 || form.getPrice3() > 0){
                treshold.put(form.getTreshold3(), form.getPrice3());
            }
        }
        oldProduct.setTresholds(treshold);

        oldProduct.setMinimalQuantity(Collections.min(treshold.keySet()));
        oldProduct.setPrice(treshold.get(oldProduct.getMinimalQuantity()));


//        Product oldProduct = getProductById(form.getId());
//        oldProduct.setDescription(form.getDescription());
//        oldProduct.setMinimalQuantity(form.getMinimalQuantity());
//        oldProduct.setPrice(form.getPrice());
        productRepository.save(oldProduct);
    }

    public Map<String, List<Product>> getProductOnIndexPage() {
        Map<String, List<Product>> result = new HashMap<>();
        for(Category category : Category.values()) {
            List<Product> products =
                    productRepository.findByCategory(category, new PageRequest(0, 5, Sort.Direction.DESC, "uploadDate")).getContent();

            result.put(category.name(), products);
        }
        return result;
    }

    public Page<Product> getProductByCategoryWithPageRequest(Category category, PageRequest pageRequest) {
        return productRepository.findByCategory(category, pageRequest);
    }

    public Page<Product> searchProduct(String keyword, PageRequest pageRequest){
        return productRepository.findByNameContainingIgnoreCase(keyword, pageRequest);
    }



}
