package com.twelfth.project.springmvcform.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = MyCustomCodeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomCode {

    // Define default MyCustomCode value
    public String value() default "MVC";
    
    // Define default MyCustomCode error message
    public String message() default "Error: cannot find MVC as prefix";

    // Define default groups to group all validation constrain
    public Class<?>[] groups() default {};
    
    // Define default payload to define addition info about validation error
    public Class<? extends Payload>[] payload() default {};

}
