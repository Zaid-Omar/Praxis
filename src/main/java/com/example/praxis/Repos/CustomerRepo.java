package com.example.praxis.Repos;


import com.example.praxis.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c JOIN FETCH c.orders")
    List<Customer> findAllWithJoins();
}
