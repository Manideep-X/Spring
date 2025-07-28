package com.fifteenth.project.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(12)
public class AddAccountObjAspect {

    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter, & of any class
    @Before("execution(* add*(com.fifteenth.project.springaop.model.Account))")
    public void beforeAddAccAdviceObj(JoinPoint joinPoint) {
        
        System.out.println("----- { 12 } @Before method inside @Aspect class [OBJ] -----");
        
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
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter and/or more params, & of any class
    @Before("execution(* add*(com.fifteenth.project.springaop.model.Account, ..))")
    public void beforeAddAccAdviceObjMore(JoinPoint joinPoint) {

        System.out.println("----- { 12 } @Before method inside @Aspect class [OBJ & MORE] -----");
        
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
    
    // This method will only execute before any method with "add" prefix with obj. of Account as a parameter and/or more params, & of any class
    @Before("execution(* add*(..))")
    public void beforeAddAdviceAnyParam(JoinPoint joinPoint) {
        
        System.out.println("----- { 12 } @Before method inside @Aspect class [TO ALL ADD] -----");
        
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
