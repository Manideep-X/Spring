package com.tenthjava.project.springsecurity.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // @Bean
    // InMemoryUserDetailsManager inMemoryUserDetailsManager() {

    //     // Creating user John(Employee), Mary(Manager), Susan(Manager,Admin)

    //     // Since there are users in the security configuration class (this class) the username and password from the properties file will NOT be considered.

    //     UserDetails john = User.builder()
    //                         .username("john")
    //                         .password("{noop}123")
    //                         .roles("EMPLOYEE")
    //                         .build();

    //     UserDetails mary = User.builder()
    //                         .username("mary")
    //                         .password("{noop}123")
    //                         .roles("EMPLOYEE", "MANAGER")
    //                         .build();

    //     UserDetails susan = User.builder()
    //                         .username("susan")
    //                         .password("{noop}123")
    //                         .roles("EMPLOYEE", "MANAGER", "ADMIN")
    //                         .build();

    //     return new InMemoryUserDetailsManager(john, mary, susan);
    // }

    @Bean // This method is use if the users and authorities(roles) are in the DB.
    UserDetailsManager userDetailsManager(DataSource dataSource) { // Injects Data source auto-configured by Spring Boot.

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource); // Tells Spring security to use JDBC authentication.

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT name, pass, active FROM members WHERE name = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_name, user_role FROM roles WHERE user_name = ?");
        // "?" is parameter placeholder. The value will be the username from login. 

        return jdbcUserDetailsManager;

    }


    // SecurityFilterChain tells spring how to filter & secure HTTP requests
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http.authorizeHttpRequests(configurer -> configurer
            .requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
            .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE") // /** means to handle all subpaths
            .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
            .requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
            .requestMatchers(HttpMethod.PATCH, "api/employees/**").hasRole("MANAGER")
            .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
        );
        
        // HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        // CSRF(Cross-Server Request Forgery) is disabled as it is not required in stateless REST APIs
        http.csrf(csrf -> csrf.disable());
        
        // It tells Spring to finalise and create an object of SecurityFilterChain
        return http.build(); 
    }

}
