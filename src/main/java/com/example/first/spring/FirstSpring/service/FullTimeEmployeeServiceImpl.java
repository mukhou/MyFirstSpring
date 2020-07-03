/* 
User: Urmi
Date: 2/1/2020 
Time: 3:10 PM
*/

package com.example.first.spring.FirstSpring.service;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Qualifier("fullTime")
public class FullTimeEmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public FullTimeEmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll(){
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee add(Employee employee) {
        log.info("############ inside add method of fulltime employee service");
        employeeRepository.save(employee);
        return employeeRepository.findByFirstName(employee.getFirstName());
    }
}
