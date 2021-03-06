package com.LabaLaba.repository;

import com.LabaLaba.entity.Category;
import com.LabaLaba.entity.Product;
import com.LabaLaba.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

//    Collection<Product> findByModelStartingWithIgnoreCase(String name);
//    Collection<Product> findByNameEndingWithIgnoreCase(String name);
//    Collection<Product> findByNameContainingWithIgnoreCase(String name);

    //Collection<Product> findByProductLikeIgnoreCase(String model);

    @Query("SELECT p FROM Product p where LOWER(p.name) like LOWER(CONCAT('%',:keyword,'%'))")
    public Collection<Product> findByKeyWord(@Param("keyword") String keyword);

    Collection<Product> findByNameContainingIgnoreCase(String name);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

//    @Query("SELECT p FROM Product p where LOWER(p.name) like LOWER(CONCAT('%',:keyword,'%'))")
//    Page<Product> findByKeyWord(@Param("keyword") String keyword, Pageable pageable);

//    MakeModel findByModelStartingWithIgnoreCase(String model); //SQL => LIKE 'model%'
//    MakeModel findByModelEndingWithIgnoreCase(String model); //SQL => LIKE '%model'
//    MakeModel findByModelContainingIgnoreCase(String model);
}

