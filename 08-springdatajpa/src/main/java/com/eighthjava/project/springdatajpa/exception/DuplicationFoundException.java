package com.eighthjava.project.springdatajpa.exception;

public class DuplicationFoundException extends RuntimeException {
    
    public DuplicationFoundException(String msg) {
        super(msg);
    }

    public DuplicationFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
