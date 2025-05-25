package com.firstjava.project.springboot.initialcode1.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BasicRestController {

    @GetMapping("/")
    public String displayString() {
        return "Hello Spring Boot in VS Code";
    }

    @Value("${creator.name}")
    private String name;

    @Value("${creator.number}")
    private String num;

    @GetMapping("/user")
    public String displayFromAppProp() {
        return "My name is : "+name+" and number is "+num;
    }
    
}
