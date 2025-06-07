package com.eleventh.project.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.eleventh.project.springthymeleaf.model.Student;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {

    @GetMapping("/name")
    public String getStudentName(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);

        return "name-form";
    }

    @PostMapping("/name")
    public String postStudentName(@ModelAttribute("student") Student theStudent, Model model) {
        
        String msg = "Welcome "+theStudent.getFirstName()+" "+theStudent.getLastName();
        model.addAttribute("message", msg);

        return "response-two-form";
    }
    

}
