package com.LabaLaba.repository;

import com.LabaLaba.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rien on 12/17/16.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByCustomerIdOrderByCreationDateDesc(Long customerId);
    List<Payment> findBySupplierIdOrderByCreationDateDesc(Long supplierId);
}
