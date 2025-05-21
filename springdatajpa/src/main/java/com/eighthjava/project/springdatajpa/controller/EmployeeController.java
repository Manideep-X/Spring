package com.eighthjava.project.springdatajpa.controller;
import com.eighthjava.project.springdatajpa.model.EmployeeEntity;
import com.eighthjava.project.springdatajpa.service.EmployeeService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable("employeeId") int id) {
        return employeeService.findById(id);
    }
    
    @PostMapping("/employees")
    public EmployeeEntity postNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.save(employeeEntity);
    }

    @PatchMapping("/employees/{employeeId}")
    public EmployeeEntity patchOldEmployee(@PathVariable("employeeId") int id, @RequestBody Map<String, Object> patch) {
        return employeeService.updateById(id, patch);
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public EmployeeEntity deleteOldEmployee(@PathVariable("employeeId") int id) {
        return employeeService.deleteById(id);
    }

}
