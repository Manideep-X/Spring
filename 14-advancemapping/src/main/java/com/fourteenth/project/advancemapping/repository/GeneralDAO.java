package com.fourteenth.project.advancemapping.repository;

import java.util.List;

import com.fourteenth.project.advancemapping.model.Course;
import com.fourteenth.project.advancemapping.model.Instructor;
import com.fourteenth.project.advancemapping.model.InstructorDetail;

public interface GeneralDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    Instructor deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

}
