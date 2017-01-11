package com.LabaLaba.repository;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by rien on 12/6/16.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Collection<Product> findBySupplier_Id(Long id);
    Collection<Product> findBySupplier(Supplier supplier);
    Product findById(Long id);
    Page<Product> findByCategory(Category category, Pageable pageable);
}

