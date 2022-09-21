package com.personalproject.AppBreadCRM.registration;

import com.personalproject.AppBreadCRM.employee.Employee;
import com.personalproject.AppBreadCRM.employee.EmployeeRole;
import com.personalproject.AppBreadCRM.employee.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final EmployeeService employeeService;
    private final EmailValidator emailValidator;

    public RegistrationService(EmployeeService employeeService, EmailValidator emailValidator) {
        this.employeeService = employeeService;
        this.emailValidator = emailValidator;
    }

    public void register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Email is not in correct format");
        }
        employeeService.signUpUser(
                new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                EmployeeRole.USER
                )
        );
    }
}
