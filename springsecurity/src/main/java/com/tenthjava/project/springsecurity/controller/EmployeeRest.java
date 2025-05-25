package com.tenthjava.project.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tenthjava.project.springsecurity.model.EmployeeEntity;
import com.tenthjava.project.springsecurity.service.EmployeeService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class EmployeeRest {

    EmployeeService employeeService;

    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmpById(@PathVariable("employeeId") int id) {
        return employeeService.findById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmp() {
        return employeeService.findAll();
    }
    
    @PostMapping("/employees")
    public EmployeeEntity postCreate(@RequestBody EmployeeEntity employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public EmployeeEntity putUpdateAll(@RequestBody EmployeeEntity employee) {
        return employeeService.updateById(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public EmployeeEntity patchUpdateById(@PathVariable("employeeId") int id, @RequestBody Map<String, Object> patch) {
        return employeeService.partialUpdateById(id, patch);
    }

}
