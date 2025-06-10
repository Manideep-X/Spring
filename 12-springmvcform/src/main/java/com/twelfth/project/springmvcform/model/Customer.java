package com.twelfth.project.springmvcform.model;

import com.twelfth.project.springmvcform.validation.MyCustomCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Customer DTO
public class Customer {

    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Min(value = 1, message = "Must be greater than zero")
    @Max(value = 10, message = "Must be less than or equal to ten")
    @NotNull(message = "No. of guests is required")
    private Integer noOfGuest;
    
    @Pattern(regexp="^[1-9][0-9]{5}$", message = "Must be 6 digit no., first digit can\'t be 0")
    @NotBlank(message = "Postal code is required")
    private String postalCode;
    
    @Min(value = 1, message = "Must be greater than zero")
    @Max(value = 100, message = "Must be less than or equal to 100")
    @NotNull(message = "Employee ID is required")
    private Integer empID;

    @MyCustomCode(value = "MNDP", message = "must start with MNDP")
    private String couponCode;
    
    public Customer() {
    }
    public Customer(@NotBlank(message = "First name is required") String firstName,
            @NotBlank(message = "Last name is required") String lastName,
            @Min(value = 1, message = "Must be greater than zero") @Max(value = 10, message = "Must be less than or equal to ten") @NotNull(message = "No. of guests is required") Integer noOfGuest,
            @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Must be 6 digit no., first digit can't be 0") @NotBlank(message = "Postal code is required") String postalCode,
            @Min(value = 1, message = "Must be greater than zero") @Max(value = 100, message = "Must be less than or equal to 100") @NotNull(message = "Employee ID is required") Integer empID,
            String couponCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfGuest = noOfGuest;
        this.postalCode = postalCode;
        this.empID = empID;
        this.couponCode = couponCode;
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

    public Integer getNoOfGuest() {
        return noOfGuest;
    }
    public void setNoOfGuest(Integer noOfGuest) {
        this.noOfGuest = noOfGuest;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public Integer getEmpID() {
        return empID;
    }
    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getCouponCode() {
        return couponCode;
    }
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}
