package com.thirteenth.project.springmvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {

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

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer -> configurer
            .requestMatchers("/").hasRole("EMPLOYEE")
            .requestMatchers("/management/**").hasRole("MANAGER")
            .requestMatchers("/system/**").hasRole("ADMIN")
            .anyRequest().authenticated() // any request to this app must be authenticated
        
        )
        .exceptionHandling(configurer -> configurer
            .accessDeniedPage("/access-denied")
        )
        .formLogin(form -> form
            .loginPage("/loginpage")
            .loginProcessingUrl("/authenticate") // authentication is handled automatically by Spring Security, so no controller request mapping is required.
            .permitAll() // it is used to show the login page to everyone without login
        )
        .logout(logout -> logout.permitAll()
        );

        return httpSecurity.build();

    }

}
