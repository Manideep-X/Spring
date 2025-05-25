package com.eighthjava.project.springdatajpa.service;

import java.util.List;
import java.util.Map;
// import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eighthjava.project.springdatajpa.exception.DuplicationFoundException;
import com.eighthjava.project.springdatajpa.exception.EmployeeNotFoundException;
import com.eighthjava.project.springdatajpa.exception.InvalidRequestException;
import com.eighthjava.project.springdatajpa.model.EmployeeEntity;
import com.eighthjava.project.springdatajpa.repository.EmployeeRepoInterface;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    EmployeeRepoInterface employeeRepository;
    ObjectMapper objectMapper;

    public EmployeeService(EmployeeRepoInterface employeeRepository, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        if (employeeRepository.existsById(employeeEntity.getId())) {
            throw new DuplicationFoundException("ID already Exists !");
        }
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity findById(int id) {
        EmployeeEntity employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee id:"+id+" is NOT FOUND"));
        return employee;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity updateById(int id, Map<String, Object> patch) {
        // Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (patch.containsKey("id")) {
            throw new InvalidRequestException("Invalid patch format");
        }
        EmployeeEntity employee = findById(id);
        EmployeeEntity employeeUpdated;
        try {
            employeeUpdated = objectMapper.updateValue(employee, patch);
        } catch (JsonMappingException e) {
            throw new InvalidRequestException("Invalid patch format");
        }
        return employeeRepository.save(employeeUpdated);
    }

    @Override
    public EmployeeEntity deleteById(Integer id) {
        EmployeeEntity employee = findById(id);
        // employeeRepository.delete(employee); // This will also give the same result.
        employeeRepository.deleteById(id);
        return employee;
    }

}
