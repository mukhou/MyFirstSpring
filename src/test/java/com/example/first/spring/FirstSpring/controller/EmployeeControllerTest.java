/* 
User: Urmi
Date: 10/3/2020 
Time: 4:29 PM
*/

package com.example.first.spring.FirstSpring.controller;

import com.example.first.spring.FirstSpring.domain.Employee;
import com.example.first.spring.FirstSpring.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(employeeController)
                .setControllerAdvice(new CustomExceptionHandler())
                .build();
    }

    @Test
    public void getEmployeeById() throws Exception {
        //given
        Employee employee = Employee.builder().id(1L).firstName("Urmi").lastName("Banerjee").build();

        //when
        when(employeeService.findById(anyLong())).thenReturn(employee);
        mockMvc.perform(get(EmployeeController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo("Urmi")));
    }






}
