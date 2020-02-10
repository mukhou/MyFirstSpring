/* 
User: Urmi
Date: 2/1/2020 
Time: 12:46 PM
*/

package com.example.first.spring.FirstSpring.service;

import com.example.first.spring.FirstSpring.domain.Employee;

import java.util.Collections;
import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);

    default List<Employee> findAll(){
        return Collections.emptyList();
    }

    Employee add(Employee employee);

}
