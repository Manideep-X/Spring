package com.eighthjava.project.springdatajpa.repository;
import com.eighthjava.project.springdatajpa.model.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepoInterface extends JpaRepository<EmployeeEntity, Integer> {
    // Now we can use JPA repository's methods in Service layer by implimenting this interface.
}
