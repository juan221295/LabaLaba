package com.LabaLaba.service;

import com.LabaLaba.entity.Comment;
import com.LabaLaba.entity.Customer;
import com.LabaLaba.entity.Product;
import com.LabaLaba.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 1/11/17.
 */
@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment getCommentById(Long id){
        return commentRepository.findById(id);
    }

    public Comment addComment(String text, Customer customer, Product product){
        Comment comment = new Comment();
        comment.setText(text);
        comment.setCommentator(customer);
        comment.setProduct(product);

        return commentRepository.save(comment);

    }

    public Collection<Comment> getAll(){
        return commentRepository.findAll();
    }

    public Collection<Comment> findByProduct(Product product){
        return commentRepository.findByProduct(product);
    }

    public void deleteProduct(Long id){
        commentRepository.delete(id);
    }
}
