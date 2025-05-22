package com.eighthjava.project.springdatajpa.exception;

public class InvalidRequestException extends RuntimeException {
    
    public InvalidRequestException(String msg) {
        super(msg);
    }

    public InvalidRequestException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
