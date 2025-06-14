package com.twelfth.project.springmvcform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import com.twelfth.project.springmvcform.model.Employee;
import com.twelfth.project.springmvcform.service.EmployeeService;

import java.util.List;
import java.util.Map;


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
        
        employeeService.save(newEmployee);

        return "redirect:/api/employees";
    }

    // UPDATE AN EMPLOYEE'S DETAILS
    @PutMapping("/employees")
    public Employee putEmp(@RequestBody Employee employee) {
        return employeeService.updateAllById(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmpById(@RequestBody Map<String, Object> patch, @PathVariable("employeeId") int id) {
        return employeeService.updateById(id, patch);
    }
    
    // DELETE AN EMPLOYEE
    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmpById(@PathVariable("employeeId") int id) {
        return employeeService.deleteById(id);
    }
    

}
