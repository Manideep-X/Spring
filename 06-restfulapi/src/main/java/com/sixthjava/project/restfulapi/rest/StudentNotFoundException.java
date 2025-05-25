package com.sixthjava.project.restfulapi.rest;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String msg) {
        super(msg);
    }
    
    public StudentNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

