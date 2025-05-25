package com.seventhjava.project.restwithcrud.service;
import com.seventhjava.project.restwithcrud.model.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeInterfaceService {

    EmployeeEntity save(EmployeeEntity employeeEntity);

    EmployeeEntity findById(int id);

    List<EmployeeEntity> findAll();

    EmployeeEntity updateById(EmployeeEntity employeeEntity);

    EmployeeEntity partialUpdateById(int id, Map<String, Object> patch);
    
    EmployeeEntity deleteById(Integer id);

}
