package com.personalproject.AppBreadCRM.order;

import com.personalproject.AppBreadCRM.customer.Customer;
import com.personalproject.AppBreadCRM.issue.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/customers/{customerId}/orders")
    public ModelAndView readOneCustomer(@PathVariable long customerId){
        ModelAndView maw = new ModelAndView();
        List<Order> orderList = orderService.readAllOrders(customerId);
        maw.setViewName("customerorderspage");
        if (!orderList.isEmpty()){
            maw.addObject("orderList", orderList);
            maw.addObject("customerInfo", orderList.iterator().next().getCustomer());
        }
        else{
            maw.setViewName("customernoorderspage.html");
        }
        return maw;
    }


    @GetMapping(value = "/orders")
    public ModelAndView readAllOrders(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("orders");
        maw.addObject("orderList", orderService.readAllOrders());
        return maw;
    }
    @GetMapping(value = "/customers/{customerId}/orders/{id}")
    public ModelAndView readOneOrder(@PathVariable long id){
            ModelAndView maw = new ModelAndView();
            maw.setViewName("orderpage");
            maw.addObject("orderInfo", orderService.getOrderById(id));
            return maw;
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
