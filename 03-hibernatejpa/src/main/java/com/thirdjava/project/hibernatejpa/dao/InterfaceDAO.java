package com.thirdjava.project.hibernatejpa.dao;

import java.util.List;

import com.thirdjava.project.hibernatejpa.entity.StudentData;

public interface InterfaceDAO {
    
    // DAO interface method to save details in DB
    void save(StudentData studentData);

    // DAO interface method to find data by ID(Primary key)
    StudentData findByID(Integer i);
    
    // DAO interface method to fetch data of all student
    List<StudentData> findAllStudent();

    // DAO interface method to fetch data of student by email
    List<StudentData> findByEmail(String str);

    // DAO interface method to update last name by ID
    void updateFirstName(Integer i, String str);

    // DAO interface method to update email of all american users by email
    Integer updateEmail(String emailStr, String newEmail);

    // DAO interface method to delete a row using the first name
    Integer deleteList(String firstName);

    // DAO interface method to delete a row using the id of student
    void deleteUsingId(Integer id) throws Exception;
}
