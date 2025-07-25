package com.fourteenth.project.advancemapping.repository;

import java.util.List;

import com.fourteenth.project.advancemapping.model.Course;
import com.fourteenth.project.advancemapping.model.Instructor;
import com.fourteenth.project.advancemapping.model.InstructorDetail;
import com.fourteenth.project.advancemapping.model.Student;

public interface GeneralDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    Instructor deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    Course findCourseById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    void deleteInstructorByIdBidir(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseWithReviewById(int id);

    Course findCourseWithStudentById(int id);

    Student findStudentWithCourseById(int id);

    void updateStudent(Student student);

    void deleteCourseNotStudentById(int id);

    void deleteStudentById(int id);

}
