package com.LabaLaba.repository;


import com.LabaLaba.entity.Comment;
import com.LabaLaba.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by rien on 1/3/17.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Collection<Comment> findByProduct_Id(Long id);
    Collection<Comment> findByProduct(Product product);
    Comment findById(Long id);

    @Modifying
    @Transactional
    @Query("delete from Comment c where c.product = :product")
    public void deleteByProduct(@Param("product") Product product);

}
