package com.twelfth.project.springmvcform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.twelfth.project.springmvcform.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
