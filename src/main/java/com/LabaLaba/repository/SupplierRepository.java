package com.LabaLaba.repository;

import com.LabaLaba.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rien on 11/28/16.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    public Supplier findBySupplierId(Long supplierId);
//    public Supplier findByDate(Long date);
}