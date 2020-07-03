/* 
User: Urmi
Date: 6/30/2020 
Time: 8:31 AM
*/

package com.example.first.spring.FirstSpring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeAspect {

    /*@Pointcut("execution (* com.example.first.spring.FirstSpring.service.EmployeeService.add(..))")
    private void addEmployeeCall(){

    }*/

    @Before("execution (* com.example.first.spring.FirstSpring.service.EmployeeService.add(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

}
