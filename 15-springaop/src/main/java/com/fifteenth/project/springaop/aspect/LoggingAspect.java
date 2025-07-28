package com.fifteenth.project.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class LoggingAspect {

    // This method will get executed before addAccount() method of any class
    // to mention a specific class: @Before("execution(public void com.fifteenth.project.springaop.dao.AccountDAO.addAccount())")
    // @Before("execution(public void addAccount())")

    // This method will only execute before addAccount() method of AccountDAO class
    // @Before("execution(public void com.fifteenth.project.springaop.dao.AccountDAO.addAccount())")

    // This method will only execute before any method with "add" prefix of any class
    // * is the wildcard
    // @Before("execution(public void add*())")

    // This method will only execute before any method with "add" prefix of any return type & of any class with no parameter
    // Access specifier is optional, so removed.
    @Before("execution(* add*())")
    public void beforeAddAccAdvice(JoinPoint joinPoint) {

        System.out.println("----- { 1 } @Before method inside @Aspect class [NO PARAM] -----");

        // This will get the method signature from JoinPoint
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    
        // This will display the method signature
        System.out.println("[Method] "+methodSignature);

        // Display method arguments
        for (Object args : joinPoint.getArgs()) {
            System.out.println("\t\t -> "+args);
        }
        System.out.println("");

    }

}
