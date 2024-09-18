package com.example.praxis.Service;

import com.example.praxis.Entity.Order;
import com.example.praxis.Repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

    // Beispiel für die Vermeidung des N+1-Problems
    public List<Order> getOrdersWithCustomersAndItems() {
        return orderRepo.findAllWithJoins();
    }
}
