package com.tenthjava.project.springsecurity.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tenthjava.project.springsecurity.model.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class EmployeeDAO implements EmployeeInterfaceDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(EmployeeEntity employeeEntity) {
        entityManager.persist(employeeEntity);
    }
    
    @Override
    public EmployeeEntity readById(int id) {
        return entityManager.find(EmployeeEntity.class, id);
    }
    
    @Override
    public List<EmployeeEntity> readAll() {
        return entityManager.createQuery("FROM EmployeeEntity", EmployeeEntity.class).getResultList();
    }
    
    @Override
    public EmployeeEntity updateById(EmployeeEntity employeeEntity) {
        return entityManager.merge(employeeEntity);
    }
    
    @Override
    public void deleteById(EmployeeEntity employeeEntity) {
        entityManager.remove(employeeEntity);
    }

}
