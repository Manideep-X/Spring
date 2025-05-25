package com.secondjava.project.inject.dependencyinjection.rest;
import com.secondjava.project.inject.dependencyinjection.Engine;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BasicRest {

    private Engine engine;
    private Engine engine2;
    private Engine engine3;

    // @Autowired is not required as there is only one constructor
    // @Qualifier has higher priority than @Primary.
    // @Qualifier is use to specifically choose which bean (using bean id) I want to inject.
    // The bean id is same as the class name (or method name if using @Bean) but the first character need to be in lower case.
    public BasicRest(@Qualifier("bike") Engine engine, 
                     @Qualifier("bike") Engine engine2,
                     @Qualifier("busCon") Engine engine3) 
    {
        this.engine = engine;
        this.engine2 = engine2;
        this.engine3 = engine3;
    }
    
    @GetMapping("/")
    public String getMethodName() {
        return ".... Basic rest controller is working !! ....";
    }

    @GetMapping("/engine")
    public String injectEngine() {
        return engine.engineSpec()+engine2.engineSpec();
    }

    @GetMapping("/check")
    public String checkObjEql() {
        return "True when both instances are equal (Singleton bean scope),</br> False when not equal (Prototype bean scope)</br></br> :[ "+(engine == engine2)+" ] that means [ "+((engine == engine2)?"Singleton":"Prototype")+" ]";
    }

    @GetMapping("/config")
    public String injectConfig() {
        return engine3.engineSpec();
    }
    
    
}
