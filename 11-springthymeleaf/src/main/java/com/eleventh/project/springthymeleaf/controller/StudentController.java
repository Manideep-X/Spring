package com.eleventh.project.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.eleventh.project.springthymeleaf.model.Student;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {

    // @Value annotation will inject data from the properties file to this field.
    @Value("${countries}")
    private List<String> countries;
    
    @Value("${genders}")
    private List<String> genders;

    @Value("${techStacks}")
    private List<String> techStacks;

    @GetMapping("/name")
    public String getStudentName(Model model) {
        model.addAttribute("currDate", java.time.LocalDateTime.now());

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        model.addAttribute("genders", genders);
        model.addAttribute("techStacks", techStacks);

        return "name-form";
    }

    @PostMapping("/name")
    public String postStudentName(@ModelAttribute("student") Student theStudent, Model model) {
        model.addAttribute("currDate", java.time.LocalDateTime.now());
        
        String theName = theStudent.getFirstName()+" "+theStudent.getLastName()+"("+theStudent.getGender()+")";
        String techStacks = "Technology used are: ";
        for (String eachStack : theStudent.getTechStack()) {
            techStacks += eachStack+", ";
        } techStacks += "etc.";
        String msg = "Welcome "+theName+" to our "+theStudent.getCountry()+" server. "+techStacks;
        model.addAttribute("message", msg);

        return "response-two-form";
    }
    

}
