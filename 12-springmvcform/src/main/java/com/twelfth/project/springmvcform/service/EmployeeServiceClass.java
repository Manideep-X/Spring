package com.twelfth.project.springmvcform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twelfth.project.springmvcform.model.Employee;
import com.twelfth.project.springmvcform.repository.EmployeeRepository;

@Service
public class EmployeeServiceClass implements EmployeeService {

    EmployeeRepository employeeRepository;
    ObjectMapper objectMapper;

    public EmployeeServiceClass(EmployeeRepository employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Employee save(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            throw new RuntimeException("Employee ID already exists");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee ID not found"));
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateById(int id, Map<String, Object> patch) {

        if (patch.containsKey("id")) {
            throw new RuntimeException("Invalid request body");
        }

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee ID not found"));

        Employee updateEmployee;
        try {
            updateEmployee = objectMapper.updateValue(employee, patch);
        } catch (JsonMappingException e) {
            throw new RuntimeException("Invalid request body");
        }

        return employeeRepository.save(updateEmployee);
    }

    @Override
    public Employee updateAllById(Employee employee) {

        Employee employeeFromDB = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee ID not found"));

        return employeeRepository.save(employeeFromDB);
    }

    @Override
    public Employee deleteById(int id) {
        
        Employee employeeFromDB = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee ID not found"));

        employeeRepository.delete(employeeFromDB);

        return employeeFromDB;
    }

}
