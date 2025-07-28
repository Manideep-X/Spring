package com.fifteenth.project.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(12)
public class AddAccountObjAspect {

    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter, & of any class
    @Before("execution(* add*(com.fifteenth.project.springaop.model.Account))")
    public void beforeAddAccAdviceObj() {
        
        System.out.println("----- { 12 } @Before method inside @Aspect class [OBJ] -----");
        
    }
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter and/or more params, & of any class
    @Before("execution(* add*(com.fifteenth.project.springaop.model.Account, ..))")
    public void beforeAddAccAdviceObjMore() {

        System.out.println("----- { 12 } @Before method inside @Aspect class [OBJ & MORE] -----");

    }
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter and/or more params, & of any class
    @Before("execution(* add*(..))")
    public void beforeAddAdviceAnyParam() {

        System.out.println("----- { 12 } @Before method inside @Aspect class [TO ALL ADD] -----");

    }

}
