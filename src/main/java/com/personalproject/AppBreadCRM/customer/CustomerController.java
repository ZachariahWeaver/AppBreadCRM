package com.personalproject.AppBreadCRM.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ModelAndView readAllCustomers(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("customers");
        maw.addObject("customerList", customerService.readAllCustomers());
        return maw;
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
