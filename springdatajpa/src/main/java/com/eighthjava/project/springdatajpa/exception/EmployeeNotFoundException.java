package com.eighthjava.project.springdatajpa.exception;

public class EmployeeNotFoundException extends RuntimeException {
    
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    public EmployeeNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
