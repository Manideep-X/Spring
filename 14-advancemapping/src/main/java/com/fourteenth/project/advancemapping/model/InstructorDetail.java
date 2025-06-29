package com.fourteenth.project.advancemapping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public InstructorDetail() {
    }
    public InstructorDetail(String portfolio, String hobby) {
        this.portfolio = portfolio;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
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

}
