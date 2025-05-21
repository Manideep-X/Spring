package com.eighthjava.project.springdatajpa.service;
import com.eighthjava.project.springdatajpa.model.EmployeeEntity;

import java.util.List;
import java.util.Map;


public interface EmployeeServiceInterface {
    
    EmployeeEntity save(EmployeeEntity employeeEntity);

    EmployeeEntity findById(int id);

    List<EmployeeEntity> findAll();

    EmployeeEntity updateById(int id, Map<String, Object> patch);
    
    EmployeeEntity deleteById(Integer id);
    
}
