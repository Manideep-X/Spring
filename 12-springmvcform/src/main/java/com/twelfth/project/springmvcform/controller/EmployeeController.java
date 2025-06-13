package com.twelfth.project.springmvcform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String getAllEmp(Model model) {

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        
        return "list-employees";
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmpById(@PathVariable("employeeId") int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee postEmp(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee putEmp(@RequestBody Employee employee) {
        return employeeService.updateAllById(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmpById(@RequestBody Map<String, Object> patch, @PathVariable("employeeId") int id) {
        return employeeService.updateById(id, patch);
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmpById(@PathVariable("employeeId") int id) {
        return employeeService.deleteById(id);
    }
    

}
