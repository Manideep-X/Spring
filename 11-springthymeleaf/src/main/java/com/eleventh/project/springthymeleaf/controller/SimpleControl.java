package com.eleventh.project.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SimpleControl {
    
    @GetMapping("/home")
    public String getHome(Model model) {
        
        // Model passes data from controller to view(Thymeleaf) in a key-value pair.
        model.addAttribute("currDate", java.time.LocalDateTime.now());
        
        return "home";
    }
    

}
