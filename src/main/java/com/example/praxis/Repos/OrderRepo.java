package com.example.praxis.Repos;

import com.example.praxis.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.customer JOIN FETCH o.item")
    List<Order> findAllWithJoins();
}
