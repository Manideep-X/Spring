package com.ninthjava.project.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ninthjava.project.springdatarest.model.EmployeeEntity;

// The path specifies the URL under which the repository will be exposed as a REST endpoint.
// For this the main URL will be: http://localhost:8080/employees
@RepositoryRestResource(path = "employees")
public interface EmpRepoRestInterface extends JpaRepository<EmployeeEntity, Integer> {

}
