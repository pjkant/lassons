package com.lassons.customer.controller;
import com.lassons.customer.entity.Customer;
import com.lassons.customer.repository.CustomerRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Resource
    private CustomerRepository repository;

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
}