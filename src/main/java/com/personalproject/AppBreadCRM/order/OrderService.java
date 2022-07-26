package com.personalproject.AppBreadCRM.order;

import com.personalproject.AppBreadCRM.customer.Customer;
import com.personalproject.AppBreadCRM.issue.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> readAllIssues(long customerId){
        return orderRepository.findByCustomerId(customerId);
    }    public Order readOneOrder(long id){
        return getOrderById(id);
    }

    public void updateOrder(Order order){
        orderRepository.save(order);
    }

    public void createOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(long id){
        orderRepository.delete(getOrderById(id));    }

    public Order getOrderById(long id) {
        Order order = orderRepository.findById(id).get();
        return order;
    }


}
