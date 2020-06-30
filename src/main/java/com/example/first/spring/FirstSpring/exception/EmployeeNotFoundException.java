/* 
User: Urmi
Date: 6/29/2020 
Time: 2:48 PM
*/

package com.example.first.spring.FirstSpring.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

    @Getter
    private long employeeId;

    public EmployeeNotFoundException(long employeeId) {
        super("invalid employee id: " + employeeId);
        this.employeeId = employeeId;
    }
}
