package com.twelfth.project.springmvcform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.twelfth.project.springmvcform.model.Employee;
import com.twelfth.project.springmvcform.service.EmployeeService;

import java.util.List;


@Controller
@RequestMapping(path = "/api")
public class EmployeeController {

    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // VIEW ALL EMPLOYEES
    @GetMapping("/employees")
    public String getAllEmp(Model model) {

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        
        return "list-employees";
    }


    // CREATE A NEW EMPLOYEE
    @GetMapping("/employees/create-employee")
    public String getCreateEmp(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        
        return "form-employee";
    }
    @PostMapping("/employees/create-employee")
    public String postEmp(@ModelAttribute("employee") Employee newEmployee) {

        if(newEmployee.getId() != null) {
            employeeService.updateAllById(newEmployee);
        } 
        else {
            employeeService.save(newEmployee);
        }

        return "redirect:/api/employees";
    }


    // UPDATE AN EMPLOYEE'S DETAILS
    @GetMapping("/employees/update")
    public String updateEmp(@RequestParam("employeeId") int id, Model model) {
        
        Employee theEmployee = employeeService.findById(id);

        model.addAttribute("employee", theEmployee);

        return "form-employee";
    }

    
    // DELETE AN EMPLOYEE
    @GetMapping("/employees/delete")
    public String deleteEmpById(@RequestParam("employeeId") int id) {
        
        employeeService.deleteById(id);
        
        return "redirect:/api/employees";
    }
    

}
