package com.seventhjava.project.restwithcrud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seventhjava.project.restwithcrud.model.EmployeeEntity;
import com.seventhjava.project.restwithcrud.service.EmployeeService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class EmployeeRest {

    EmployeeService employeeService;

    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    // CREATE
    @PostMapping("/employees")
    public EmployeeEntity create(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.save(employeeEntity);
    }

    // READ BY ID
    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity findById(@PathVariable("employeeId") int id) {
        return employeeService.findById(id);
    }

    // READ ALL
    @GetMapping("/employees")
    public List<EmployeeEntity> findAll() {
        return employeeService.findAll();
    }
    
    // UPDATE ALL
    @PutMapping("/employees") // PUT: value of all fields will be changed
    public EmployeeEntity updateById(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateById(employeeEntity);
    }

    // UPDATE PARTIALLY
    @PatchMapping("/employees/{employeeId}")
    public EmployeeEntity partialUpdateById(@PathVariable("employeeId") int id, @RequestBody Map<String,Object> patch) {
        return employeeService.partialUpdateById(id, patch);
    }

    // DELETE
    @DeleteMapping("/employees/{employeeId}")
    public EmployeeEntity deleteById(@PathVariable("employeeId") int id) {
        return employeeService.deleteById(id);
    }

}
