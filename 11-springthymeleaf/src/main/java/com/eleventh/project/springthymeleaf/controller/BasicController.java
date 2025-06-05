package com.eleventh.project.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BasicController {

    // This method is to show the HTML form
    @RequestMapping("/show")
    public String requestShow(Model model) {
        model.addAttribute("currDate", java.time.LocalDateTime.now());
        return "initial-form";
    }
    
    // This method is to process the HTML form
    @RequestMapping("/processForm")
    public String requestProcessForm(Model model) {
        model.addAttribute("currDate", java.time.LocalDateTime.now());
        return "response-form";
    }
    

}
