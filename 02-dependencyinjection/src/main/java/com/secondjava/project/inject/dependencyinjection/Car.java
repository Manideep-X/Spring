package com.secondjava.project.inject.dependencyinjection;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
// This annotation will make this class/bean primary. You don't need qualifier annotation in RestController for this.
// @Qualifier has higher priority than @Primary
public class Car implements Engine {

    @Override
    public String engineSpec() {
        return "Engine is injected in The CAR</br>";
    }
}
