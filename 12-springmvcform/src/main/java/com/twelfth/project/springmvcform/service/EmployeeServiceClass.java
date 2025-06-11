package com.twelfth.project.springmvcform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.twelfth.project.springmvcform.model.Employee;

@Service
public class EmployeeServiceClass implements EmployeeService {

    @Override
    public Employee save(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Employee findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Employee updateById(int id, Map<String, Object> patch) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateById'");
    }

    @Override
    public Employee deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }



}
