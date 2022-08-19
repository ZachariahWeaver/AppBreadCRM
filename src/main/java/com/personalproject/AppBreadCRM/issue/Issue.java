package com.personalproject.AppBreadCRM.issue;

import com.personalproject.AppBreadCRM.order.Order;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="CustomerOrderIssue") //Table name Order is  a reserved term in PostgreSQL, Thus continuing the naming convention here
@Component
public class Issue {
    @Id
    @Column(name="ID", nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    @Autowired
    @JoinColumn(name="CUSTOMER_ORDER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;
    @Column(name="TITLE", nullable = false)
    private String title;

    @Column(name="DESCRIPTION", nullable = false)
    private String description;
    @Column(name="DATE_OPEN", nullable = false)
    private String dateOpen;
    @Column(name="DATE_CLOSED", nullable = true)
    private String dateClosed;

    public Issue() {
    }

    public Issue(long id, Order order, String title, String description, String dateOpen, String dateClosed) {
        this.id = id;
        this.order = order;
        this.title = title;
        this.description = description;
        this.dateOpen = dateOpen;
        this.dateClosed = dateClosed;
    }

    public Issue(Order order, String title, String description, String dateOpen, String dateClosed) {
        this.order = order;
        this.title = title;
        this.description = description;
        this.dateOpen = dateOpen;
        this.dateClosed = dateClosed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }
}
