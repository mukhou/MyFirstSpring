/* 
User: Urmi
Date: 2/1/2020 
Time: 12:40 PM
*/

package com.example.first.spring.FirstSpring.controller;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "This is the Employee Controller")
@RestController
@RequestMapping(EmployeeController.BASE_URL)
@Slf4j
public class EmployeeController {

    public static final String BASE_URL = "/employees";

    private final EmployeeService employeeService;

    public EmployeeController(@Qualifier("fullTime") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "This will return the employee based on id", notes = "Sample notes")
    @GetMapping("{id}")
    public Employee getById(@PathVariable("id") Long id){
        log.info("Inside employee controller");
        return employeeService.findById(id);
    }

    @ApiOperation(value = "This will return the list of all employee based on id", notes = "Sample notes")
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee){
        return employeeService.add(employee);

    }
}
