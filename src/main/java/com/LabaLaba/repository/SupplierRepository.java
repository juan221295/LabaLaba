package com.LabaLaba.repository;

import com.LabaLaba.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rien on 11/28/16.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    public Supplier findOneByEmail(String email);
    public Supplier findById(Long id);
    public Supplier findOneByEmailAndPassword(String email, String password);
//    public Supplier findByDate(Long date);
}