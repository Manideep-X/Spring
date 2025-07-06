package com.fourteenth.project.advancemapping.repository;

import com.fourteenth.project.advancemapping.model.Instructor;
import com.fourteenth.project.advancemapping.model.InstructorDetail;

public interface GeneralDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    Instructor deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

}
