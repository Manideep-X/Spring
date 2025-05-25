package com.secondjava.project.inject.dependencyinjection;

// import org.springframework.context.annotation.Scope;
// import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) or @Scope("singleton")
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) or @Scope("prototype")
public class Bike implements Engine {
    
    @Override
    public String engineSpec() {
        return "Engine is injected in The BIKE</br>";
    }
}
