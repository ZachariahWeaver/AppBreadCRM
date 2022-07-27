package com.personalproject.AppBreadCRM.issue;

import com.personalproject.AppBreadCRM.order.Order;
import com.personalproject.AppBreadCRM.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> readAllIssues(long orderId){
        return issueRepository.findByOrderId(orderId);
    }
    public Iterable<Issue> readAllIssues(){
        return issueRepository.findAll();
    }
    public Issue readOneIssue(long id){
        return getIssueById(id);
    }

    public void updateIssue(Issue issue){
        issueRepository.save(issue);
    }

    public void createIssue(Issue issue){
        issueRepository.save(issue);
    }

    public void deleteIssue(long id){
        issueRepository.delete(getIssueById(id));    }

    public Issue getIssueById(long id) {
        Issue issue = issueRepository.findById(id).get();
        return issue;
    }


}
