package com.seventhjava.project.restwithcrud.repository;

import com.seventhjava.project.restwithcrud.model.EmployeeEntity;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAO implements EmployeeInterfaceDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(EmployeeEntity employee) {
        entityManager.persist(employee);
    }

    @Override
    public EmployeeEntity readById(Integer id) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
        return employee;
    }
    
    @Override
    public List<EmployeeEntity> readAll() {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
        return query.getResultList();
    }

    @Override
    public EmployeeEntity updateById(EmployeeEntity employeeEntity) {
        return entityManager.merge(employeeEntity);
    }

    @Override
    public void deleteById(Integer id, EmployeeEntity employeeEntity) {
        entityManager.remove(employeeEntity);
    }

    

}
