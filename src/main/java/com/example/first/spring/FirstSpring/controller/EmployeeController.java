/* 
User: Urmi
Date: 2/1/2020 
Time: 12:40 PM
*/

package com.example.first.spring.FirstSpring.controller;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.exception.EmployeeNotFoundException;
import com.example.first.spring.FirstSpring.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "This is the Employee Controller")
//this is needed to enable Spring to force a bean to refresh its configuration
// (that is, to pull updated values from the Config Server) by annotating the controller with the
// Spring Cloud Config @RefreshScope and then triggering a refresh event(POST: http://localhost:8080/actuator/refresh)
@RefreshScope
//Note: Look out for this line during app startup: ConfigServicePropertySourceLocator : Fetching config from server at : http://localhost:9000
@RestController
@RequestMapping(EmployeeController.BASE_URL)
@Slf4j
public class EmployeeController {

    public static final String BASE_URL = "/employees";

    private final EmployeeService employeeService;

    @Value("${message:Hello default}")
    private String message;


    //NOTE: if you don't want to use the @Qualifier annotation, change the param name of the below constructor from
    //employeeService to "fullTimeEmployeeServiceImpl". Doing so will enable Spring to use reflection
    //to find out the corresponding impl class, FullTimeEmployeeServiceImpl.java in this case.
    //IMP: the name "fullTimeEmployeeService" won't work as the actual implementation class
    //has an "Impl" suffix to it.
    public EmployeeController(@Qualifier("fullTime") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "This will return the employee based on id", notes = "Sample notes")
    @GetMapping("{id}")
    public Employee getById(@PathVariable("id") Long id){
        log.info("Inside employee controller");
        Employee emp = employeeService.findById(id);
        if(emp == null){
            throw new EmployeeNotFoundException(id);
        }
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

    //service to test spring config server
    @GetMapping("/message/")
    public String getMessage(){
        return this.message;
    }

}
