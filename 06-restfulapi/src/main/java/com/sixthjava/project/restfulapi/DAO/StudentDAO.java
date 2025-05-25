package com.sixthjava.project.restfulapi.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sixthjava.project.restfulapi.entity.StudentData;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAO implements InterfaceDAO {

    @PersistenceContext // No need for autowiring/dependency injection as this annotation is added.
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(StudentData studentData) {
        entityManager.persist(studentData);
        // entityManager.flush();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentData findById(Integer id) {
        StudentData student = entityManager.find(StudentData.class, id);
        return student;
    }

    @Override
    public List<StudentData> displayAll() {
        TypedQuery<StudentData> query = entityManager.createQuery("FROM StudentData", StudentData.class);
        return query.getResultList();
    }

    

}
