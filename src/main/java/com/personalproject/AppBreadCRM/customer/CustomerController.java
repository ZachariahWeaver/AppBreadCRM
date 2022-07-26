package com.personalproject.AppBreadCRM.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public List<Customer> readAllCustomers(){
        return customerService.readAllCustomers();
    }
    @GetMapping(value = "/customers/{id}")
    public Customer readOneCustomer(@PathVariable long id){
        return customerService.readOneCustomer(id);
    }

    @PutMapping(value = "/customers")
    public void updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
    }

    @PostMapping(value = "/customers")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @DeleteMapping(value = "/customers/{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        customerService.deleteCustomer(id);
    }
}
