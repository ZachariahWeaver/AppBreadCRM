package com.personalproject.AppBreadCRM.customer;

import com.personalproject.AppBreadCRM.order.Order;
import net.bytebuddy.matcher.StringMatcher;
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
        Customer cust = new Customer();
        maw.setViewName("customers");
        maw.addObject("customerList", customerService.readAllCustomers());
        maw.addObject("cust", new Customer());
        return maw;
    }
    @GetMapping(value = "/customers/{id}")
    public ModelAndView readOneCustomer(@PathVariable long id){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("customerpage");
        maw.addObject("customerInfo", customerService.getCustomerById(id));
        return maw;
    }

    @PutMapping(value = "/customers")
    public void updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
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
    public ModelAndView deleteCustomer(@PathVariable("id") long id){
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customers/");

    }
}
