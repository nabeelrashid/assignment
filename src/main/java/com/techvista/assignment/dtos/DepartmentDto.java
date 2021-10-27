package com.techvista.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class DepartmentDto {

    @NotNull(message = "positive number value is required")
    private int departmentId;

    private String departmentName;

    private Integer managerId;

}
