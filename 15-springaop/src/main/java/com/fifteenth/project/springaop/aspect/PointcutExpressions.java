package com.fifteenth.project.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutExpressions {

    /*
     * Pointcut declaration for advice is use for code reuse 
     */

    // Pointcut for all methods from "dao" package
    @Pointcut("execution(* com.fifteenth.project.springaop.dao.*.*(..))")
    public void forDaoPackage() {}

    // Pointcut for getter methods
    @Pointcut("execution(* get*(..))")
    public void forGetter() {}

    // Pointcut for setter methods
    @Pointcut("execution(* set*(..))")
    public void forSetter() {}
    
    // Pointcut for all methods except getters & setters from "dao" package
    @Pointcut("forDaoPackage() && !forGetter() && !forSetter()")
    public void forAllDaoExceptGetAndSet() {}

}
