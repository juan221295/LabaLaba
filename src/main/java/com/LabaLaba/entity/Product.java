package com.LabaLaba.entity;

import com.LabaLaba.form.ProductForm;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

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
    /**Edit Treshold**/
    @ElementCollection
    private Map<Long, Long> tresholds;
    /**EoEdit Treshold**/
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "product")
    private Collection<Comment> comments;

    public Product() {}

    public Product(Long id) {
        this.setId(id);
    }

    public Product(ProductForm form) {
        /**Edit Treshold**/
        if(form.getId() != null) {
            this.id = form.getId();
        }
        /**EoEdit Treshold**/

        this.setName(form.getName());
//        this.setPrice(form.getPrice());
//        this.setMinimalQuantity(form.getMinimalQuantity());
        this.setSupplier(form.getSupplier());
        this.setUploadDate(new DateTime());
        this.setCategory(form.getCategory());
        this.setDescription(form.getDescription());

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
        this.setTresholds(treshold);

        this.setMinimalQuantity(Collections.min(treshold.keySet()));
        this.setPrice(treshold.get(this.getMinimalQuantity()));
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

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Map<Long, Long> getTresholds() {
        return tresholds;
    }

    public void setTresholds(Map<Long, Long> tresholds) {
        this.tresholds = tresholds;
    }
}
