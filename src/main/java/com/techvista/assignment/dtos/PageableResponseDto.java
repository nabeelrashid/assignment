package com.techvista.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageableResponseDto {

    private int size;
    private int page;
    private int totalPages;
    private int totalElements;
    private List <EmployeeDto> employeeDtos;
}
