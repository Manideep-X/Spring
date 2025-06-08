package com.twelfth.project.springmvcform.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.twelfth.project.springmvcform.model.Customer;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder // This annotation makes the method execute before binding from data to the model object.
    public void initBinder(WebDataBinder binder) {
        
        // Create an instance of the class StringTrimmerEditor which helps to remove whitespaces.
        StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true); 
        
        // Below one, finds the form fields of type String and replace the leading & trailing whitespaces(if any) to null.
        binder.registerCustomEditor(String.class, stringTrimmer); 
    }

    @GetMapping("/")
    public String getForm(Model model) {

        model.addAttribute("customer", new Customer());
        return "customer-form";

    }

    @PostMapping("/process-form") // @Valid tells Spring MVC to perform validation and bind the validation result
                                  // using BindingResult
    public String postForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-response";
    }

}
