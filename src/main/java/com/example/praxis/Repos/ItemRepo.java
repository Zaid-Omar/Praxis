package com.example.praxis.Repos;

import com.example.praxis.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i JOIN FETCH i.orders")
    List<Item> findAllWithJoins();
}
