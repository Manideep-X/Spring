package com.tenthjava.project.springsecurity.service;

import java.util.List;
import java.util.Map;

import com.tenthjava.project.springsecurity.model.EmployeeEntity;

public interface EmpServiceInterface {

    EmployeeEntity save(EmployeeEntity employeeEntity);

    EmployeeEntity findById(int id);

    List<EmployeeEntity> findAll();

    EmployeeEntity updateById(EmployeeEntity employeeEntity);

    EmployeeEntity partialUpdateById(int id, Map<String, Object> patch);
    
    EmployeeEntity deleteById(Integer id);

}
