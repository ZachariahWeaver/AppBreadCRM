package com.personalproject.AppBreadCRM.order;

import com.personalproject.AppBreadCRM.customer.Customer;
import com.personalproject.AppBreadCRM.issue.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/customers/{customerId}/orders")
    public List<Order> readAllOrders(@PathVariable long customerId){
         return orderService.readAllIssues(customerId);    }

    @GetMapping(value = "/orders")
    public Iterable<Order> readAllOrders(){
        return orderService.readAllIssues();    }
    @GetMapping(value = "/customers/{customerId}/orders/{id}")
    public Order readOneOrder(@PathVariable long id){
        return orderService.readOneOrder(id);
    }

    @PutMapping(value = "/customers/{customerId}/orders")
    public void updateOrder(Order order){
        orderService.updateOrder(order);
    }

    @PostMapping(value = "/customers/{customerId}/orders")
    public void createOrder(@RequestBody Order order, @PathVariable long customerId){
        order.setCustomer(new Customer(customerId, "", "", "", "", ""));
        orderService.createOrder(order);
    }

    @DeleteMapping(value = "/customers/{customerId}/orders")
    public void deleteOrder(@PathVariable long id){
        orderService.deleteOrder(id);
    }
}
