package com.eleventh.project.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class BasicController {

    // This method is to show the HTML form
    @RequestMapping("/show")
    public String requestShow(Model model) {
        // Model passes data from controller to view(Thymeleaf) in a key-value pair.
        model.addAttribute("currDate", java.time.LocalDateTime.now());
        return "initial-form";
    }
    
    // This method is to process the HTML form
    @RequestMapping(path="/processForm", method=RequestMethod.GET) // same as @GetMapping
    public String requestProcessForm(Model model) {
        model.addAttribute("currDate", java.time.LocalDateTime.now());
        return "response-form";
    }
    
    @RequestMapping(path="/processFormTwo", method=RequestMethod.GET) // same as @GetMapping
    public String requestProcessForm2(@RequestParam("studentEmail") String email ,HttpServletRequest request, Model model) {
        // @RequestParam is use to bind a form parameter to a variable.
        // HttpServletRequest holds form data.
        model.addAttribute("currDate", java.time.LocalDateTime.now());

        String msg = "Welcome "+request.getParameter("studentName")+" to Spring MVC";
        model.addAttribute("message", msg.toUpperCase()+" Email: "+email);

        return "response-two-form";
    }

}
