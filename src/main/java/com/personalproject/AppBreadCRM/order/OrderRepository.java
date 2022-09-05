package com.personalproject.AppBreadCRM.order;

import com.personalproject.AppBreadCRM.issue.Issue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByCustomerId(long customerId);

}
