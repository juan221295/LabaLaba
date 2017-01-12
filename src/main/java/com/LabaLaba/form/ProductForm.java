package com.LabaLaba.form;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rien on 12/6/16.
 */
public class ProductForm {
    private Long id;
    private String name;
//    private long price;
//    private long minimalQuantity;
    private Category category;
    private MultipartFile file;
    private Supplier supplier;
    private String description;


    private long treshold1;
    private long treshold2;
    private long treshold3;
    private long price1;
    private long price2;
    private long price3;

    public ProductForm() {}

    public ProductForm(Product product) {
        this.setId(product.getId());
        this.setDescription(product.getDescription());
        this.setName(product.getName());
        this.setCategory(product.getCategory());
        this.setSupplier(product.getSupplier());

        /**Edit Treshold**/
        Map<Long, Long> tresholds = product.getTresholds();
        List<Long> tresholdQuantity = new ArrayList(tresholds.keySet());

        this.setTreshold1(tresholdQuantity.get(0));
        this.setTreshold2(tresholdQuantity.get(1));
        this.setTreshold3(tresholdQuantity.get(2));
        this.setPrice1(tresholds.get(tresholdQuantity.get(0)));
        this.setPrice2(tresholds.get(tresholdQuantity.get(1)));
        this.setPrice3(tresholds.get(tresholdQuantity.get(2)));
        /**EoEdit Treshold**/
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public long getPrice() {
//        return price;
//    }
//
//    public void setPrice(long price) {
//        this.price = price;
//    }
//
//    public long getMinimalQuantity() {
//        return minimalQuantity;
//    }
//
//    public void setMinimalQuantity(long minimalQuantity) {
//        this.minimalQuantity = minimalQuantity;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTreshold1() {
        return treshold1;
    }

    public void setTreshold1(long treshold1) {
        this.treshold1 = treshold1;
    }

    public long getTreshold2() {
        return treshold2;
    }

    public void setTreshold2(long treshold2) {
        this.treshold2 = treshold2;
    }

    public long getTreshold3() {
        return treshold3;
    }

    public void setTreshold3(long treshold3) {
        this.treshold3 = treshold3;
    }

    public long getPrice1() {
        return price1;
    }

    public void setPrice1(long price1) {
        this.price1 = price1;
    }

    public long getPrice2() {
        return price2;
    }

    public void setPrice2(long price2) {
        this.price2 = price2;
    }

    public long getPrice3() {
        return price3;
    }

    public void setPrice3(long price3) {
        this.price3 = price3;
    }
}
