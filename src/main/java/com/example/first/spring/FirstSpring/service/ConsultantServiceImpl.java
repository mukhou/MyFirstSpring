/* 
User: Urmi
Date: 2/5/2020 
Time: 9:29 AM
*/

package com.example.first.spring.FirstSpring.service;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("consultant")
public class ConsultantServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public ConsultantServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee add(Employee employee) {
        return null;
    }
}
