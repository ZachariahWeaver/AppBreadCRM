package com.personalproject.AppBreadCRM.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> readAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }
    public Customer readOneCustomer(long id){
        return getCustomerById(id);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        customerRepository.delete(getCustomerById(id));
    }


    public Customer getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

}
