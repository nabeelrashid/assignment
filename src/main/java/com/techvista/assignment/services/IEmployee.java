package com.techvista.assignment.services;

import com.techvista.assignment.dtos.EmployeeDto;
import com.techvista.assignment.dtos.PageableResponseDto;
import com.techvista.assignment.dtos.ResponseDto;
import org.springframework.http.ResponseEntity;

/**
 * @author Muhammad Nabeel Rashid
 */
public interface IEmployee {
    ResponseEntity<ResponseDto> addEmployee(EmployeeDto employeeDto);

    ResponseEntity<ResponseDto> update(int id, EmployeeDto employeeDto);

    ResponseEntity<PageableResponseDto> getListOfEmployee(int page, int size);

    ResponseEntity<EmployeeDto> getAnEmployee(int id);
}
