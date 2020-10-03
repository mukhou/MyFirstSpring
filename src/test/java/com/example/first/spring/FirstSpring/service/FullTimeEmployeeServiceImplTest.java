/* 
User: Urmi
Date: 10/3/2020 
Time: 4:43 PM
*/

package com.example.first.spring.FirstSpring.service;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class FullTimeEmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private FullTimeEmployeeServiceImpl fullTimeEmployeeService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getEmployeeByFirstName(){
        //given
        Employee employee = Employee.builder().id(1L).firstName("Urmi").lastName("Banerjee").build();

        //when
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));

        Employee result = fullTimeEmployeeService.findById(1L);

        assertEquals("Urmi", result.getFirstName());
    }

}
