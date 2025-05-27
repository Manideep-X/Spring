package com.tenthjava.project.springsecurity.repository;

import java.util.List;

import com.tenthjava.project.springsecurity.model.EmployeeEntity;

public interface EmployeeInterfaceDAO {

    void create(EmployeeEntity employeeEntity);

    EmployeeEntity readById(int id);

    List<EmployeeEntity> readAll();

    EmployeeEntity updateById(EmployeeEntity employeeEntity);

    void deleteById(EmployeeEntity employeeEntity);

}
