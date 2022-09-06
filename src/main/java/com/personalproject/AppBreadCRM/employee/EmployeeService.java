package com.personalproject.AppBreadCRM.employee;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return employeeRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public String signUpUser(Employee employee){
        boolean userExists = employeeRepository.findByEmail(employee.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("User already exists, please go to sign in page");
        }
       String encodedPassword = bCryptPasswordEncoder.encode(employee.getPassword());

        employee.setPassword(encodedPassword);

        employeeRepository.save(employee);
        return "works";
    }
}
