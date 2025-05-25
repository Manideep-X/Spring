package com.ninthjava.project.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ninthjava.project.springdatarest.model.EmployeeEntity;

@RepositoryRestResource(path = "employees")
public interface EmpRepoRestInterface extends JpaRepository<EmployeeEntity, Integer> {

}
