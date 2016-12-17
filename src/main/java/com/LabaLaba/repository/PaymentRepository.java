package com.LabaLaba.repository;

import com.LabaLaba.entity.Customer;
import com.LabaLaba.entity.Payment;
import com.LabaLaba.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by rien on 12/17/16.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    public Collection<Payment> findByCustomer(Customer customer);

    public Collection<Payment> findBySupplier(Supplier supplier);

}
