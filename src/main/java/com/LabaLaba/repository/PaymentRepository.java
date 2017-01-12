package com.LabaLaba.repository;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.entity.Payment;
import com.LabaLaba.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by rien on 12/17/16.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Collection<Payment> findByCustomer(Customer customer);
    Collection<Payment> findBySupplier(Supplier supplier);
    List<Payment> findByCustomerOrderByCreationDateDesc(Customer customer);
    List<Payment> findBySupplierOrderByCreationDateDesc(Supplier supplier);
}
