package com.twelfth.project.springmvcform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.twelfth.project.springmvcform.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Spring Data JPA will automatically parse the method name and look for a specific format and pattern to create the appropiate query.
    public List<Employee> findAllByOrderByLastNameAsc();
    // Now this method can be used in the service layer

}
