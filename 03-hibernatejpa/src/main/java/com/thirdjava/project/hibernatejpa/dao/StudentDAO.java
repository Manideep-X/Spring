package com.thirdjava.project.hibernatejpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
// import jakarta.persistence.PersistenceContext;

import com.thirdjava.project.hibernatejpa.entity.StudentData;

@Repository
public class StudentDAO implements InterfaceDAO {
    
    // @PersistenceContext  // Autowiring is possible but this one is recommended
                            // This ensures the right behavior, especially in multi-threaded, transactional environments.
    public EntityManager entityManager;

    // @Autowired // not required as there is only one constructor (mentioned before).
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(StudentData studentData) {
        entityManager.persist(studentData);
    }

    @Override
    @Transactional(readOnly = true)//if not included there will be a LazyInitializationException when accessing lazy-loaded fields. (Not neccessary but recommended)
    public StudentData findByID(Integer i) {
        return entityManager.find(StudentData.class, i);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentData> findAllStudent() {
        TypedQuery<StudentData> queryForAll = entityManager.createQuery("FROM StudentData ORDER BY lastName DESC", StudentData.class);
        return queryForAll.getResultList();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<StudentData> findByEmail(String str) {
        TypedQuery<StudentData> queryForEmail = entityManager.createQuery("FROM StudentData WHERE email LIKE :emailValue", StudentData.class);
        queryForEmail.setParameter("emailValue", "%"+str+"%");
        return queryForEmail.getResultList();
    }

    @Override
    @Transactional
    public void updateFirstName(Integer i, String str) {
        StudentData studentData = entityManager.find(StudentData.class, i);
        studentData.setFirstName(str);
        entityManager.merge(studentData);
    }

    @Override
    @Transactional
    public Integer updateEmail(String emailStr, String newEmail) {
        Query query = entityManager.createQuery("UPDATE StudentData SET email = :newEmail WHERE email LIKE :emailStr");
        // Query is required to build and prepare the update. Used for Non-SELECT queries (like UPDATE, DELETE).
        query.setParameter("emailStr", "%"+emailStr+"%");
        query.setParameter("newEmail", newEmail);
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public Integer deleteList(String firstName) {
        Query query = entityManager.createQuery("DELETE FROM StudentData WHERE firstName = :firstName");
        query.setParameter("firstName", firstName);
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUsingId(Integer id) throws Exception {
        StudentData studentData = entityManager.find(StudentData.class, id);

        if (studentData != null) {
            entityManager.remove(studentData);
        } else {
            throw new Exception("Can't find the student");
        }
    }
    
}
