package com.personalproject.AppBreadCRM.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate <String> {
    public boolean test(String s) {
 //     TODO: Regex to validate email
       return true;
    }
}
