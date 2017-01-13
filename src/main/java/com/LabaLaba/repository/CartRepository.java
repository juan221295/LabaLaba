package com.LabaLaba.repository;

import com.LabaLaba.entity.CartItem;
import com.LabaLaba.entity.Customer;
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
public interface CartRepository extends JpaRepository<CartItem, Long> {
    CartItem findByOwnerAndProduct(Customer owner, Product product);

    Collection<CartItem> findByOwner(Customer owner);

    @Modifying
    @Transactional
    @Query("delete from CartItem c where c.product = :product")
    public void deleteByProduct(@Param("product") Product product);
}
