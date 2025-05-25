package com.secondjava.project.inject.dependencyinjection;

public class Bus implements Engine {
    
    @Override
    public String engineSpec() {
        return "Engine injected into the BUS using @Configuration & @Bean";
    }
}
