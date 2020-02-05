/* 
User: Urmi
Date: 2/1/2020 
Time: 12:40 PM
*/

package com.example.first.spring.FirstSpring.controller;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier("fullTime") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/employee/{id}", produces = "application/json")
    public Employee getById(@PathVariable("id") Long id){
        log.info("Inside employee controller");
        return employeeService.findById(id);
    }

    @PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
    public Employee create(@RequestBody Employee employee){
        return employeeService.add(employee);

    }
}
