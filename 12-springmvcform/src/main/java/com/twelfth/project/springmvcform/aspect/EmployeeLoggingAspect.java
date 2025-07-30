package com.twelfth.project.springmvcform.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeLoggingAspect {

    // Set a logger
    private Logger empLogger = Logger.getLogger(getClass().getName());

    // Setup of pointcut declaration for controller, repository and service package.
    @Pointcut("execution(* com.twelfth.project.springmvcform.controller.*.*(..))")
    private void forEmpControllerPackage() {}
    
    @Pointcut("execution(* com.twelfth.project.springmvcform.repository.*.*(..))")
    private void forEmpRepositoryPackage() {}
    
    @Pointcut("execution(* com.twelfth.project.springmvcform.service.*.*(..))")
    private void forEmpServicePackage() {}

    // Combined pointcut declaration for controller, repository and service package.
    @Pointcut("forEmpControllerPackage() || forEmpRepositoryPackage() || forEmpServicePackage()")
    private void forAppAdvice() {}

    // This will execute before any methods of these packages: controller, repository, service
    @Before("forAppAdvice()")
    public void before(JoinPoint joinPoint) {
        
        // Displaying the calling method
        empLogger.info("----- [@Before] Calling method: "+joinPoint.getSignature().toShortString());
        
        // Displaying the arguments of the method
        for (Object arg : joinPoint.getArgs()) {
            empLogger.info("----- [@Before] Arguments: "+arg);
        }
        
    }
    
    // This will execute after any methods of these packages: controller, repository, service
    @AfterReturning(
        pointcut = "forAppAdvice()",
        returning = "result"
    )
    public void after(JoinPoint joinPoint, Object result) {
        
        // Displaying the called method
        empLogger.info("----- [@AfterReturning] Called method: "+joinPoint.getSignature().toShortString());
        
        // Displaying the returned value
        empLogger.info("----- [@AfterReturning] Result: "+result);

    }

}
