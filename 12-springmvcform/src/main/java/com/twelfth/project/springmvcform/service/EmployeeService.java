package com.twelfth.project.springmvcform.service;

import java.util.List;
import java.util.Map;

import com.twelfth.project.springmvcform.model.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    Employee updateById(int id, Map<String, Object> patch);

    Employee deleteById(int id);

}
