package com.fifteenth.project.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(23)
public class NoGetAndSetAspect {

    // This method will execute before all methods in every class of "dao" package 
    @Before("com.fifteenth.project.springaop.aspect.PointcutExpressions.forDaoPackage()")
    public void beforeAllAdviceAnyParam() {
        System.out.println("----- { 23 } @Before method inside @Aspect class [TO ALL METHODS] -----");
    }

    @Before("com.fifteenth.project.springaop.aspect.PointcutExpressions.forAllDaoExceptGetAndSet()")
    public void beforeAllExceptGetAndSet() {

        System.out.println("----- { 23 } @Before method inside @Aspect class [EXCEPT GET* & SET*] -----");

    }

}
