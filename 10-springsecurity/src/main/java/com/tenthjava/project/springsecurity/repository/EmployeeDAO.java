package com.tenthjava.project.springsecurity.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tenthjava.project.springsecurity.model.EmployeeEntity;


@Repository
public class EmployeeDAO implements EmployeeInterfaceDAO {

    @Transactional
    @Override
    public void create(EmployeeEntity employeeEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
    @Transactional(readOnly = true)
    @Override
    public EmployeeEntity readById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readById'");
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<EmployeeEntity> readAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }
    
    @Transactional
    @Override
    public EmployeeEntity updateById(EmployeeEntity employeeEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateById'");
    }
    
    @Transactional
    @Override
    public void deleteById(int id, EmployeeEntity employeeEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
