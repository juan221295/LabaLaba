package com.LabaLaba.repository;

import com.LabaLaba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rien on 11/5/16.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
