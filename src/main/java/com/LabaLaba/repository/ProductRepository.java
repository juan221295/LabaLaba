package com.LabaLaba.repository;

import com.LabaLaba.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by rien on 12/6/16.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Collection<Product> findBySupplier_SupplierId(Long supplierId);
    Product findById(Long id);
}
