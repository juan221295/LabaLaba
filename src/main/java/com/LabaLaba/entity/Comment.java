package com.LabaLaba.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by Juan on 1/11/17.
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime uploadDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;

    private String text;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer commentator;
//    private Customer commentator;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(DateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Customer getCommentator() {
        return commentator;
    }

    public void setCommentator(Customer commentator) {
        this.commentator = commentator;
    }

}
