package com.LabaLaba.entity;

import com.LabaLaba.form.ProductForm;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by rien on 11/28/16.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private Category category;
    private Long price;
    private Long minimalQuantity;
    private String imagePath;
    private String description;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime uploadDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Supplier supplier;


    public Product() {}

    public Product(Long id) {
        this.setId(id);
    }

    public Product(ProductForm form) {
        this.setName(form.getName());
        this.setPrice(form.getPrice());
        this.setMinimalQuantity(form.getMinimalQuantity());
        this.setSupplier(form.getSupplier());
        this.setUploadDate(new DateTime());
        this.setCategory(form.getCategory());
        this.setDescription(form.getDescription());
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(Long minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(DateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}
