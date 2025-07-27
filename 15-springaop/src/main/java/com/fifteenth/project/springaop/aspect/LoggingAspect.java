package com.fifteenth.project.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    // This method will get executed before addAccount() method of any class
    // to mention a specific class: @Before("execution(public void com.fifteenth.project.springaop.dao.AccountDAO.addAccount())")
    // @Before("execution(public void addAccount())")

    // This method will only execute before addAccount() method of AccountDAO class
    // @Before("execution(public void com.fifteenth.project.springaop.dao.AccountDAO.addAccount())")

    // This method will only execute before any method with "add" prefix of any class
    // * is the wildcard
    // @Before("execution(public void add*())")

    // This method will only execute before any method with "add" prefix of any return type & of any class
    // Access specifier is optional, so removed.
    @Before("execution(* add*())")
    public void beforeAddAccAdvice() {

        System.out.println("----- @Before method inside @Aspect class -----");

    }
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter, & of any class
    @Before("execution(* add*(com.fifteenth.project.springaop.model.Account))")
    public void beforeAddAccAdviceObj() {
        
        System.out.println("----- @Before method inside @Aspect class [OBJ] -----");
        
    }
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter and/or more params, & of any class
    @Before("execution(* add*(com.fifteenth.project.springaop.model.Account, ..))")
    public void beforeAddAccAdviceObjMore() {

        System.out.println("----- @Before method inside @Aspect class [OBJ & MORE] -----");

    }
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter and/or more params, & of any class
    @Before("execution(* add*(..))")
    public void beforeAddAdviceAnyParam() {

        System.out.println("----- @Before method inside @Aspect class [TO ALL ADD] -----");

    }

    /*
     * Pointcut declaration for advice is use for code reuse 
     */

    // Pointcut for all methods from "dao" package
    @Pointcut("execution(* com.fifteenth.project.springaop.dao.*.*(..))")
    private void forDaoPackage() {}
    
    // This method will execute before all methods in every class of "dao" package 
    @Before("forDaoPackage()")
    public void beforeAllAdviceAnyParam() {
        System.out.println("----- @Before method inside @Aspect class [TO ALL METHODS] -----");
    }

    // Pointcut for getter methods
    @Pointcut("execution(* get*(..))")
    private void forGetter() {}

    // Pointcut for setter methods
    @Pointcut("execution(* set*(..))")
    private void forSetter() {}
    
    // Pointcut for all methods except getters & setters from "dao" package
    @Pointcut("forDaoPackage() && !forGetter() && !forSetter()")
    private void forAllDaoExceptGetAndSet() {}

    @Before("forAllDaoExceptGetAndSet()")
    public void beforeAllExceptGetAndSet() {

        System.out.println("----- @Before method inside @Aspect class [EXCEPT GET* & SET*] -----");

    }

}
