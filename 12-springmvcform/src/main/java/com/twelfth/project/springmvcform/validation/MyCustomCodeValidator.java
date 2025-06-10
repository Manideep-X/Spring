package com.twelfth.project.springmvcform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyCustomCodeValidator implements ConstraintValidator<MyCustomCode, String> {

    private String customPrefix;

    @Override
    public void initialize(MyCustomCode customAnnotation) {
        customPrefix = customAnnotation.value();
    }

    @Override
    public boolean isValid(String fieldCode, ConstraintValidatorContext additionalErrorMessages) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }
}
