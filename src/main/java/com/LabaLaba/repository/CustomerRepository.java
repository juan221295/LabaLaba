package com.LabaLaba.repository;

import com.LabaLaba.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rien on 11/5/16.
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findOneByEmail(String email);

}
