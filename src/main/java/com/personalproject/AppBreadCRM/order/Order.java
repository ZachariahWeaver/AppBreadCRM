package com.personalproject.AppBreadCRM.order;

import com.personalproject.AppBreadCRM.customer.Customer;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="CustomerOrder") //Table name Order is  a reserved term in PostgreSQL, that's why it's named as such
@Component
public class Order {
    @Id
    @Column(name="ID", nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    @Autowired
    @JoinColumn(name="CUSTOMER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;
    @Column(name="ITEM", nullable = false)
    private String item;
    @Column(name="DATE", nullable = false)
    private String date;
    @Column(name="PAID", nullable = false)
    private boolean paid;
    @Column(name="SHIPPED", nullable = false)
    private boolean shipped;

    public Order() {
    }

    public Order(long id, long customerId, String item, String date, boolean paid, boolean shipped) {
        this.id = id;
        this.customer = new Customer(customerId, "", "", "", "", "");
        this.item = item;
        this.date = date;
        this.paid = paid;
        this.shipped = shipped;
    }

    public Order(long customerId, String item, String date, boolean paid, boolean shipped) {
        this.customer = new Customer(customerId, "", "", "", "", "");
        this.item = item;
        this.date = date;
        this.paid = paid;
        this.shipped = shipped;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean getShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
