package com.example.praxis.Service;

import com.example.praxis.Entity.Customer;
import com.example.praxis.Repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepo.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    // Hier könnte JOIN Fetching benutzt werden, um das N+1-Problem zu verhindern
    public List<Customer> getAllCustomersWithOrders() {
        return customerRepo.findAllWithJoins();
    }
}
