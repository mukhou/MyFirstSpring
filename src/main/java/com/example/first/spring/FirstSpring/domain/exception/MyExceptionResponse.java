/* 
User: Urmi
Date: 6/29/2020 
Time: 2:30 PM
*/

package com.example.first.spring.FirstSpring.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MyExceptionResponse {

    private Date date;
    private String errorMsg;
    private String details;
}
