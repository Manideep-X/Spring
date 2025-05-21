package com.eighthjava.project.springdatajpa.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.eighthjava.project.springdatajpa.model.EmployeeEntity;
import com.eighthjava.project.springdatajpa.repository.EmployeeRepoInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    EmployeeRepoInterface employeeRepository;

    public EmployeeService(EmployeeRepoInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public EmployeeEntity findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<EmployeeEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public EmployeeEntity updateById(int id, Map<String, Object> patch) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateById'");
    }

    @Override
    public EmployeeEntity deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
