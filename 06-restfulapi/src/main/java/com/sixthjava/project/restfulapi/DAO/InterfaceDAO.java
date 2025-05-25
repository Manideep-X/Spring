package com.sixthjava.project.restfulapi.DAO;

import java.util.List;

import com.sixthjava.project.restfulapi.entity.StudentData;

public interface InterfaceDAO {

    void save(StudentData studentData);

    StudentData findById(Integer id);

    List<StudentData> displayAll();

}
