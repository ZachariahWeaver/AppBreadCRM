package com.personalproject.AppBreadCRM.issue;

import com.personalproject.AppBreadCRM.customer.Customer;
import com.personalproject.AppBreadCRM.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping(value = "/customers/{customerId}/orders/{orderId}/issues")
    public List<Issue> readAllIssues(@PathVariable long orderId) {
        return issueService.readAllIssues(orderId);
    }

    @GetMapping(value = "/issues")
    public ModelAndView readAllOrders(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("issues");
        maw.addObject("issueList", issueService.readAllIssues());
        return maw;
    }


    @GetMapping(value = "/customers/{customerId}/orders/{orderId}/issues/{id}")
    public Issue readOneIssue(@PathVariable long id){
        return issueService.readOneIssue(id);
    }

    @PutMapping(value = "/customers/{customerId}/orders/{orderId}/issues")
    public void updateIssue(Issue issue){
        issueService.updateIssue(issue);
    }

    @PostMapping(value = "/customers/{customerId}/orders/{orderId}/issues")
    public void createIssue(@RequestBody Issue issue, @PathVariable long customerId, @PathVariable long orderId){
        issue.setOrder(new Order(orderId, customerId, "", "", false, false));
        issueService.createIssue(issue);
    }

    @DeleteMapping(value = "/customers/{customerId}/orders/{orderId}/issues/{id}")
    public void deleteIssue(@PathVariable long id){
        issueService.deleteIssue(id);
    }
}
