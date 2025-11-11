package com.lassons.customer.controller;
import com.lassons.customer.entity.Customer;
import com.lassons.customer.repository.CustomerRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Resource
    private CustomerRepository repository;

    @GetMapping("/hello")  // <-- Add this
    public String hello() {
        return "Hello from Customer Controller!";
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        Optional<Customer> customer = repository.findById(id);
        return customer.orElse(null);
    }

    @PutMapping("/{id}")
    public Customer putCustomer(@PathVariable String id, @RequestBody Customer updatedCustomer) {
        updatedCustomer.setId(id);
        return repository.save(updatedCustomer);
    }
    @PostMapping("/batch")
    public List<Customer> createCustomers(@RequestBody List<Customer> customers) {
        return repository.saveAll(customers);
    }
    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}