/* 
User: Urmi
Date: 2/1/2020 
Time: 12:46 PM
*/

package com.example.first.spring.FirstSpring.service;

import com.example.first.spring.FirstSpring.domain.Employee;

public interface EmployeeService {

    Employee findById(Long id);

    Employee add(Employee employee);

}
