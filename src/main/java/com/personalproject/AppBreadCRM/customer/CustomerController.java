package com.personalproject.AppBreadCRM.customer;

import com.personalproject.AppBreadCRM.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ModelAndView readAllCustomers(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("customers");
        maw.addObject("customerList", customerService.readAllCustomers());
        maw.addObject("cust", new Customer());
        return maw;
    }
    @GetMapping(value = "/customers/{id}")
    public ModelAndView readOneCustomer(@PathVariable long id){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("customerorderspage");
        maw.addObject("ord", new Order());
        maw.addObject("customerInfo", customerService.getCustomerById(id));
        return maw;
    }

    @PutMapping(value = "/customers")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        ModelAndView maw = new ModelAndView();
        Customer cust = new Customer();
        maw.setViewName("customers");
        maw.addObject("customerList", customerService.readAllCustomers());
        maw.addObject("cust", new Customer());
        return maw;
    }

    @PostMapping(value = "/customers")
    public ModelAndView createCustomer(@ModelAttribute ("cust") Customer customer){
        customerService.createCustomer(customer);
        ModelAndView maw = new ModelAndView();
        Customer cust = new Customer();
        maw.setViewName("customers");
        maw.addObject("customerList", customerService.readAllCustomers());
        maw.addObject("cust", new Customer());
        return maw;
    }

    @DeleteMapping(value = "/customers/{id}")
    @ResponseBody
    public ModelAndView deleteCustomer(@PathVariable ("id") long id){
        customerService.deleteCustomer(id);
        ModelAndView maw = new ModelAndView();
        Customer cust = new Customer();
        maw.setViewName("customers");
        maw.addObject("customerList", customerService.readAllCustomers());
        maw.addObject("cust", new Customer());
        return maw;
    }
}
