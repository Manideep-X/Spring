package com.secondjava.project.inject.dependencyinjection.config;

import com.secondjava.project.inject.dependencyinjection.Bus;
import com.secondjava.project.inject.dependencyinjection.Engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusConfig{
    
    // poviding access modifier to a bean method is not neccessary.
    // They can have default (package-private) access, and Spring will still detect and register them correctly.
    // @Bean("beanId") // we can give this bean a custom bean ID like this.
    @Bean
    public Engine busCon() {
        return new Bus();
    }

}
