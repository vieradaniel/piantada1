package com.piantada1.piantada1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piantada1.piantada1.model.Customer;
import com.piantada1.piantada1.model.User;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
