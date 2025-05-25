package com.sixthjava.project.restfulapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // This makes the class a global exception handler.
public class StudentRestExceptionHandler {

    // This annotation is use to handle exception which will return a ResponseEntity<>
    // Response Entity is use to manually construct a HTTP response.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
        
        StudentErrorResponse studentErr = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(studentErr, HttpStatus.NOT_FOUND);
        
    }
    
    // This exception handler method is use to catch all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> allException(Exception ex) {
        
        StudentErrorResponse studentErr = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),"Just a BAD REQUEST",System.currentTimeMillis());
    
        return new ResponseEntity<>(studentErr, HttpStatus.BAD_REQUEST);
    
    }

}
