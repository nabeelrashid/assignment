package com.techvista.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class EmployeeDto {
    private int employeeId;
    @Size(min = 2, message = "FirstName length is too small")
    @NotEmpty(message = "FirstName is mandatory")
    private String firstName;
    @NotEmpty(message = "LastName is mandatory")
    @Size(min = 2, message = "LastName length is too small")
    private String lastName;
    @NotEmpty(message = "Email is mandatory")
    private String email;
    @Pattern(regexp = "^[0-9-]*$", message = "Incorrect phone number pattern")
    private String phoneNumber;
    private Date hireDate;
    @Min(1)
    private Integer salary;
    private Integer managerId;
    @Valid
    @NotNull
    private DepartmentDto department;
}
