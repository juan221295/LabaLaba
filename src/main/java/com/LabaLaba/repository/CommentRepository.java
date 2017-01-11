package com.LabaLaba.repository;


import com.LabaLaba.entity.Comment;
import com.LabaLaba.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by rien on 1/3/17.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Collection<Comment> findByProduct_Id(Long id);
    Collection<Comment> findByProduct(Product product);
    Comment findById(Long id);


}
