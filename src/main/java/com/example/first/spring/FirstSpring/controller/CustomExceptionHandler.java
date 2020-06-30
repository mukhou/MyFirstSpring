/* 
User: Urmi
Date: 6/29/2020 
Time: 2:34 PM
*/

package com.example.first.spring.FirstSpring.controller;

import com.example.first.spring.FirstSpring.domain.exception.MyExceptionResponse;
import com.example.first.spring.FirstSpring.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAll(Exception ex, WebRequest request){
        MyExceptionResponse res = MyExceptionResponse.builder().date(new Date())
                .errorMsg(ex.getMessage())
                .details(request.getDescription(false)).build();
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<Object> handleEmpNotFound(EmployeeNotFoundException ex, WebRequest request){
        MyExceptionResponse res = MyExceptionResponse.builder().date(new Date())
                .errorMsg(ex.getMessage())
                .details(request.getDescription(false)).build();
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

}
