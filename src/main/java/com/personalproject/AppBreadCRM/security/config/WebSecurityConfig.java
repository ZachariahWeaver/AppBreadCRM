package com.personalproject.AppBreadCRM.security.config;

import com.personalproject.AppBreadCRM.employee.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final EmployeeService employeeService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(EmployeeService employeeService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeService = employeeService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String [] staticResources = {
                "/registration",
                "/login",
                "/images/BreadCRMLogo.png",
                "/images/UserLogo.jpg",
                "/favicon.ico"
        };
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(staticResources)
                .permitAll().anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)
                .loginPage("/login")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(employeeService);

        return provider;
    }
}
