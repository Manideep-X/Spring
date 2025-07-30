package com.fifteenth.project.springaop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fifteenth.project.springaop.model.Account;


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


    /*
     * @AfterReturning is used to add aspect after completing the execution of the mentioned method.
     */


    // Add advice for @AfterReturning on the findAccounts method in AccountDAO
    @AfterReturning(
        pointcut = "execution(* com.fifteenth.project.springaop.dao.AccountDAO.findAccounts(..))", 
        returning = "theList"
    )
    public void afterReturningFindAccAdvice(JoinPoint joinPoint, List<Account> theList) {

        System.out.println("----- { 1 } @AfterReturning method inside @Aspect class [ANY PARAM, findAccounts] -----");

        // This will get the method signature from the JoinPoint
        String method = joinPoint.getSignature().toShortString();

        System.out.println("-----\t\tMethod: "+method);
        System.out.println("-----\t\tResult: "+theList+"\n");

        // Post-processing: modifying the data before sending it to the calling program
        // Convert all name and level to uppercase
        setAllToUpper(theList);

    }
    private void setAllToUpper(List<Account> theList) {
        for (Account account : theList) {
            account.setName(account.getName().toUpperCase());
            account.setLevel(account.getLevel().toUpperCase());
        }
    }

    /*
     * @AfterThrowing annotation adds aspect after an exception is throwned from the mentioned method.
     */

    @AfterThrowing(
        pointcut = "execution(* com.fifteenth.project.springaop.dao.AccountDAO.findAccounts(..))",
        throwing = "exception"
    )
    public void afterThrowingFindAccAdvice(JoinPoint joinPoint, Throwable exception) {

        System.out.println("-+-+- { 1 } @AfterThrowing method inside @Aspect class [ANY PARAM, findAccounts] -+-+-");

        // Displaying the method name and the exception that occured
        System.out.println("-+-+-\t\tMethod: "+joinPoint.getSignature().toShortString());
        System.out.println("-+-+-\t\tException: "+exception);

    }

    /*
     * @After advice annotated method will get executed after the completion of the execution of the mentioned regardless of whether it throws an exception or not.
     */

    @After("execution(* com.fifteenth.project.springaop.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccAdvice(JoinPoint joinPoint) {

        System.out.println("----- { 1 } @After method will RUN ANYWAY [ANY PARAM, findAccounts] -----");

    }

    /*
     * @Around advice annotation is the combination of all i.e., @Before, @AfterReturning, @AfterThrowing and @After.
     */

    @Around("execution(* com.fifteenth.project.springaop.service.TrafficMonitor*.getTrafficStatus(..))")
    public Object aroundGetStatusAdvice(
        ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {

        System.out.println("----- @Around method has STARTED the execution -----");

        // store the current time or starting time of execution
        long startTime = System.currentTimeMillis();

        Object result = null;
        // handle the exception in Arround advice
        try {
            // Start the execution
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("-+-+- Exception occured and is handled by AROUND ADVICE -+-+-");
            System.out.println("-+-+-\tException Message: "+e.getMessage());

            // Rethrowing the exception, so the calling method should handle it.
            throw e;
        }

        // Calculation of total time taken for execution
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("----- @Around method has ENDED the execution -----");
        System.out.println("\n-----\tDuration of execution: "+duration);
        System.out.println("-----\tResult: "+result+"\n");

        return result;

    }

}
