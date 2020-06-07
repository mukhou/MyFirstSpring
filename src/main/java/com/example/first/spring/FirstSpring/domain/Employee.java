/* 
User: Urmi
Date: 2/1/2020 
Time: 12:40 PM
*/

package com.example.first.spring.FirstSpring.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "This is the first name", required = true)
    private String firstName;
    @ApiModelProperty(value = "This is the last` name", required = true)
    private String lastName;
}
