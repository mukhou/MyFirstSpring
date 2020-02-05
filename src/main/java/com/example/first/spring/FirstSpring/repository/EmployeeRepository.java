/* 
User: Urmi
Date: 2/1/2020 
Time: 1:07 PM
*/

package com.example.first.spring.FirstSpring.repository;

import com.example.first.spring.FirstSpring.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByFirstName(String firstName);
}
