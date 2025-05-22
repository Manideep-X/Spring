package com.eighthjava.project.springdatajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eighthjava.project.springdatajpa.model.HttpResponseEntity;

@ControllerAdvice
public class ExceptionHandlerDto {

    @ExceptionHandler
    public ResponseEntity<HttpResponseEntity> handleNotFound(EmployeeNotFoundException ex) {

        HttpResponseEntity response = new HttpResponseEntity(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<HttpResponseEntity> handleDuplication(DuplicationFoundException ex) {

        HttpResponseEntity response = new HttpResponseEntity(HttpStatus.CONFLICT.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }

    @ExceptionHandler
    public ResponseEntity<HttpResponseEntity> handleInvalidRequest(InvalidRequestException ex) {

        HttpResponseEntity response = new HttpResponseEntity(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler
    public ResponseEntity<HttpResponseEntity> handleAllOther(Exception ex) {

        HttpResponseEntity response = new HttpResponseEntity(HttpStatus.BAD_REQUEST.value(), "BAD VALUE in request body", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
