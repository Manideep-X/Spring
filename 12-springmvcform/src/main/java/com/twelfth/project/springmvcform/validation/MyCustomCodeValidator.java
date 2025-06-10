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
        
        boolean result;

        if (fieldCode != null) {
            result = fieldCode.startsWith(customPrefix);
        }
        else{
            return true;
        }

        return result;

    }
}
