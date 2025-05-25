package com.seventhjava.project.restwithcrud.repository;
import com.seventhjava.project.restwithcrud.model.EmployeeEntity;

import java.util.List;

public interface EmployeeInterfaceDAO {

    void create(EmployeeEntity employeeEntity);

    EmployeeEntity readById(Integer id);

    List<EmployeeEntity> readAll();

    EmployeeEntity updateById(EmployeeEntity employeeEntity);

    void deleteById(Integer id, EmployeeEntity employeeEntity);

}
