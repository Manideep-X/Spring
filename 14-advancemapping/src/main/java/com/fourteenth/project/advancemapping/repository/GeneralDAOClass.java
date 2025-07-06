package com.fourteenth.project.advancemapping.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fourteenth.project.advancemapping.model.Instructor;
import com.fourteenth.project.advancemapping.model.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class GeneralDAOClass implements GeneralDAO {

    EntityManager entityManager;

    public GeneralDAOClass(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE INSTRUCTOR WITH INSTRUCTOR_DETAIL
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    // FIND INSTRUCTOR ALONG WITH INSTRUCTOR DETAIL BY ID
    @Override
    @Transactional(readOnly = true)
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    // DELETE INSTRUCTOR ALONG WITH INSTRUCTOR DETAIL BY ID
    @Override
    @Transactional
    public Instructor deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        return instructor;
    }

    // FIND INSTRUCTOR DETAIL ALONG WITH INSTRUCTOR BY ID
    @Override
    @Transactional(readOnly = true)
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    // DELETE INSTRUCTOR DETAIL ALONG WITH INSTRUCTOR BY ID
    @Override
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetail);
    }

}
