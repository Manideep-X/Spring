package com.fourteenth.project.advancemapping.repository;

import org.springframework.transaction.annotation.Transactional;

import com.fourteenth.project.advancemapping.model.Instructor;

import jakarta.persistence.EntityManager;

public class GeneralDAOClass implements GeneralDAO {

    EntityManager entityManager;

    public GeneralDAOClass(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

}
