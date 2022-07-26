package com.personalproject.AppBreadCRM.customer;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Component
public class Customer {
    @Id
    @Column(name="ID", nullable = false, updatable = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name="LAST_NAME", nullable = false)
    private String lastName;
    @Column(name="ADDRESS", nullable = false)
    private String address;
    @Column(name="EMAIL", nullable = false)
    private String email;
    @Column(name="PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName, String address, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String address, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
