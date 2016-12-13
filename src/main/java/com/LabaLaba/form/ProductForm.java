package com.LabaLaba.form;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Supplier;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rien on 12/6/16.
 */
public class ProductForm {
    private Long id;
    private String name;
    private long price;
    private long minimalQuantity;
    private Category category;
    private MultipartFile file;
    private Supplier supplier;

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(long minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

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
}
