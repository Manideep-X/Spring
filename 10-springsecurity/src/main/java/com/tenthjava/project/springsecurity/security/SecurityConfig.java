package com.tenthjava.project.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        // Creating user John(Employee), Mary(Manager), Susan(Manager,Admin)

        // Since there are users in the security configuration class (this class) the username and password from the properties file will NOT be considered.

        UserDetails john = User.builder()
                            .username("john")
                            .password("{noop}123")
                            .roles("EMPLOYEE")
                            .build();

        UserDetails mary = User.builder()
                            .username("mary")
                            .password("{noop}123")
                            .roles("EMPLOYEE", "MANAGER")
                            .build();

        UserDetails susan = User.builder()
                            .username("susan")
                            .password("{noop}123")
                            .roles("EMPLOYEE", "MANAGER", "ADMIN")
                            .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

}
