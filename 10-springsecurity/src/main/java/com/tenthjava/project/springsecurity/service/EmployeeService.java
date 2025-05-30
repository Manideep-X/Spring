package com.tenthjava.project.springsecurity.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenthjava.project.springsecurity.model.EmployeeEntity;
import com.tenthjava.project.springsecurity.repository.EmployeeDAO;

@Service
public class EmployeeService implements EmpServiceInterface {

    EmployeeDAO employeeDAO;
    ObjectMapper objectMapper;

    public EmployeeService(EmployeeDAO employeeDAO, ObjectMapper objectMapper) {
        this.employeeDAO = employeeDAO;
        this.objectMapper = objectMapper;
    }

    @Transactional
    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        if (employeeEntity.getId() != null) {
            throw new RuntimeException("BAD request format. Check again");
        }
        employeeDAO.create(employeeEntity);
        return employeeEntity;
    }
    
    @Transactional(readOnly = true)
    @Override
    public EmployeeEntity findById(int id) {
        EmployeeEntity employee = employeeDAO.readById(id);
        if (employee == null) {
            throw new RuntimeException("Employee with ID:"+id+" is NOT FOUND");
        }
        return employee;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<EmployeeEntity> findAll() {
        return employeeDAO.readAll();
    }
    
    @Transactional
    @Override
    public EmployeeEntity updateById(EmployeeEntity employeeEntity) {
        findById(employeeEntity.getId());
        return employeeDAO.updateById(employeeEntity);
    }
    
    @Transactional
    @Override
    public EmployeeEntity partialUpdateById(int id, Map<String, Object> patch) {
        if (patch.containsKey("id")) {
            throw new RuntimeException("BAD request format. Check again");
        }
        EmployeeEntity employee = findById(id);
        try {
            employee = objectMapper.updateValue(employee, patch);
        } catch (JsonMappingException e) {
            throw new RuntimeException("BAD request format. Check again");
        }
        return employee;
    }
    
    @Transactional
    @Override
    public EmployeeEntity deleteById(int id) {
        EmployeeEntity employee = findById(id);
        employeeDAO.deleteById(employee);
        return employee;
    }

}
