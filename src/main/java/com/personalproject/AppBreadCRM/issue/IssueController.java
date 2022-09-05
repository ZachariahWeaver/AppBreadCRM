package com.personalproject.AppBreadCRM.issue;

import com.personalproject.AppBreadCRM.customer.Customer;
import com.personalproject.AppBreadCRM.order.Order;
import com.personalproject.AppBreadCRM.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/customers/{customerId}/orders/{orderId}/issues")
    public ModelAndView readAllIssues(@PathVariable long orderId){
        ModelAndView maw = new ModelAndView();
        List<Issue> issueList = issueService.readAllIssues(orderId);
        maw.setViewName("orderissuespage");
        maw.addObject("issueList", issueList);
        maw.addObject("orderInfo", orderService.getOrderById(orderId));
        maw.addObject("iss", new Issue());

        return maw;
    }

    @GetMapping(value = "/issues")
    public ModelAndView readAllIssues(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("issues");
        maw.addObject("issueList", issueService.readAllIssues());
        return maw;
    }


    @GetMapping(value = "/customers/{customerId}/orders/{orderId}/issues/{id}")
    public ModelAndView readOneIssue(@PathVariable long id){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("issuepage");
        maw.addObject("issueInfo", issueService.getIssueById(id));
        return maw;
    }

    @PutMapping(value = "/customers/{customerId}/orders/{orderId}/issues")
    public void updateIssue(Issue issue){
        issueService.updateIssue(issue);
    }

    @PostMapping(value = "/customers/{customerId}/orders/{orderId}")
    public ModelAndView createIssue(@ModelAttribute Issue issue, @PathVariable long customerId, @PathVariable long orderId){
        issue.setOrder(new Order(orderId, customerId, "", "", false, false));
        issueService.createIssue(issue);

        ModelAndView maw = new ModelAndView();
        List<Issue> issueList = issueService.readAllIssues(orderId);
        maw.setViewName("orderissuespage");
        maw.addObject("issueList", issueList);
        maw.addObject("orderInfo", orderService.getOrderById(orderId));
        maw.addObject("iss", new Issue());

        return maw;
    }

    @DeleteMapping(value = "/customers/{customerId}/orders/{orderId}/issues/{id}")
    @ResponseBody
        public ModelAndView deleteIssue(@PathVariable("customerId") long customerId, @PathVariable("orderId") long orderId, @PathVariable("id") long id) {
            issueService.deleteIssue(id);
            return new ModelAndView("redirect:/customers/" + customerId  + "/orders/" + orderId + "/issues/");


        }
}
