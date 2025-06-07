package com.eleventh.project.springthymeleaf.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String gender;
    private List<String> techStack;
    
    public Student() {
    }
    public Student(String firstName, String lastName, String country, String gender, List<String> techStack) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.gender = gender;
        this.techStack = techStack;
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

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public List<String> getTechStack() {
        return techStack;
    }
    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }
    
}
