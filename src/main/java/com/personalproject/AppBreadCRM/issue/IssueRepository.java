package com.personalproject.AppBreadCRM.issue;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssueRepository extends CrudRepository<Issue, Long> {
    List<Issue> findByOrderId(long orderId);

}
