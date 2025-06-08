package com.twelfth.project.springmvcform.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// Customer DTO
public class Customer {

    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Min(value = 1, message = "Must be greater than zero")
    @Max(value = 10, message = "Must be less than or equal to ten")
    private int noOfGuest;

    public Customer() {
    }
    public Customer(@NotBlank(message = "First name is required") String firstName,
            @NotBlank(message = "Last name is required") String lastName,
            @Min(value = 1, message = "Must be greater than zero") @Max(value = 10, message = "Must be less than or equal to ten") int noOfGuest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfGuest = noOfGuest;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getNoOfGuest() {
        return noOfGuest;
    }
    public void setNoOfGuest(int noOfGuest) {
        this.noOfGuest = noOfGuest;
    }

}
