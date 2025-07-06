package com.fourteenth.project.advancemapping.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "portfolio")
    private String portfolio;

    @Column(name = "hobby")
    private String hobby;


    // @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
    /* 
        To only delete the instructorDetail rows without cascade deleting the instructor one, 
            1. we need to add all cascade type except the REMOVE one.
            2. And need to set instructorDetail.getInstructor().setInstructorDetail(null) before deleting the instructorDetail to break the bi-directional link.
    */
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL) // cascade is needed for add and delete operations.
    private Instructor instructor;
    // Both of the above line is used for Bi-directional one-to-one mapping along with the getter and setter for the instructor.

    public InstructorDetail() {
    }
    public InstructorDetail(String portfolio, String hobby) {
        this.portfolio = portfolio;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPortfolio() {
        return portfolio;
    }
    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", portfolio=" + portfolio + ", hobby=" + hobby + "]";
    }

}
