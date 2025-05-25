package com.seventhjava.project.restwithcrud.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seventhjava.project.restwithcrud.model.EmployeeEntity;
import com.seventhjava.project.restwithcrud.repository.EmployeeDAO;

@Service
public class EmployeeService implements EmployeeInterfaceService {

    EmployeeDAO employeeDAO;
    ObjectMapper objectMapper;

    public EmployeeService(EmployeeDAO employeeDAO, ObjectMapper objectMapper) {
        this.employeeDAO = employeeDAO;
        this.objectMapper = objectMapper;
    }

    @Transactional
    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        employeeDAO.create(employeeEntity);
        return employeeEntity;
    }

    @Transactional(readOnly = true)
    @Override
    public EmployeeEntity findById(int id) {
        EmployeeEntity employeeById = employeeDAO.readById(id);
        if (employeeById == null) {
            throw new RuntimeException("Employee with id:"+id+" is NOT FOUND");
        }
        return employeeById;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<EmployeeEntity> findAll() {
        return employeeDAO.readAll();
    }

    @Transactional
    @Override
    public EmployeeEntity updateById(EmployeeEntity employeeEntity) {
        EmployeeEntity employeeById = employeeDAO.readById(employeeEntity.getId());
        if (employeeById == null) {
            throw new RuntimeException("Employee with id:"+employeeEntity.getId()+" is NOT FOUND");
        }
        return employeeDAO.updateById(employeeEntity);
    }
    
    @Transactional
    @Override
    public EmployeeEntity partialUpdateById(int id, Map<String, Object> patch) {
        
        EmployeeEntity employeeById = employeeDAO.readById(id);
        
        if (employeeById == null) {
            throw new RuntimeException("Employee with id:"+id+" is NOT FOUND");
        } else if (patch.containsKey("id")) {
            throw new RuntimeException("[id] CAN'T BE in the Request Body");
        }
        
        EmployeeEntity modifiedEmployee;
        try {
            modifiedEmployee = objectMapper.updateValue(employeeById, patch);
        } catch (JsonMappingException e) {
            throw new RuntimeException("INVALID patch format, check it again");
        }
        return employeeDAO.updateById(modifiedEmployee);
    }
    
    @Transactional
    @Override
    public EmployeeEntity deleteById(Integer id) {
        EmployeeEntity employeeById = employeeDAO.readById(id);
        if (employeeById == null) {
            throw new RuntimeException("Employee with id:"+id+" is NOT FOUND");
        }
        employeeDAO.deleteById(id, employeeById);
        return employeeById;
    }


}
