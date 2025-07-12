package com.fourteenth.project.advancemapping.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fourteenth.project.advancemapping.model.Course;
import com.fourteenth.project.advancemapping.model.Instructor;
import com.fourteenth.project.advancemapping.model.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
    
    // FIND COURSE'S INFO BY COURSE ID
    @Override
    @Transactional(readOnly = true)
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    // DELETE INSTRUCTOR DETAIL ALONG WITH INSTRUCTOR BY ID
    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // instructorDetail.getInstructor().setInstructorDetail(null);
        /* 
            To only delete the instructorDetail rows without cascade deleting the instructor one, 
                1. we need to add all cascade type except the REMOVE one.
                2. And need to set instructorDetail.getInstructor().setInstructorDetail(null) before deleting the instructorDetail to break the bi-directional link.
        */

        entityManager.remove(instructorDetail);
    }

    // FINDING COURSES FOR A INSTRUCTOR BY ITS ID
    @Override
    @Transactional(readOnly = true)
    public List<Course> findCoursesByInstructorId(int id) {
        
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :ins_id", Course.class);
        query.setParameter("ins_id", id);

        return query.getResultList();
    }
    
    // FETCHING INSTRUCTOR AND COURSE IN ONE QUERY (MAINLY FOR LAZY FETCH TYPE)
    @Override
    @Transactional(readOnly = true)
    public Instructor findInstructorByIdJoinFetch(int id) {
        
        TypedQuery<Instructor> query = entityManager.createQuery(
            "from Instructor as i JOIN FETCH i.courses where i.id = :ins_id", Instructor.class
        );
        query.setParameter("ins_id", id);
        
        return query.getSingleResult();    
    }

    // UPDATING INSTRUCTOR
    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    // UPDATING COURSE
    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    // DELETE INSTRUCTOR BY INSTRUCTOR'S ID
    @Override
    @Transactional
    public void deleteInstructorByIdBidir(int id) {
        
        Instructor instructor = entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();

        for (Course course : courses) {
            course.setInstructor(null);
        }

        entityManager.remove(instructor);

    }
    
    // DELETE COURSE BY COURSE'S ID
    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    // SAVE A COURSE AS WELL AS REVIEW(S)
    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course); // this will save review as well due to CascadeType.ALL
    }

    // FINDING COURSE AND IT'S REVIEW(S) USING COURSE ID
    @Override
    @Transactional(readOnly = true)
    public Course findCourseWithReviewById(int id) {
        
        TypedQuery<Course> query = entityManager.createQuery(
            "select c from Course as c JOIN FETCH c.reviews where c.id = :course_id", Course.class);

        query.setParameter("course_id", id);

        return query.getSingleResult();

    }

}
