package com.techvista.assignment.controllers;

import com.techvista.assignment.dtos.EmployeeDto;
import com.techvista.assignment.dtos.PageableResponseDto;
import com.techvista.assignment.dtos.ResponseDto;
import com.techvista.assignment.services.IEmployee;
import com.techvista.assignment.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author Muhammad Nabeel Rashid
 */
@Slf4j
@Controller
@RequestMapping(Constants.EMPLOYEE_BASE_URI)
public class EmployeeController {

    private IEmployee iEmployee;

    public EmployeeController(IEmployee iEmployee) {
        this.iEmployee = iEmployee;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> addEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        log.info("Request received to add an employee");
        return iEmployee.addEmployee(employeeDto);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> updateEmployee(@RequestParam int id, @RequestBody @Valid EmployeeDto employeeDto) {
        log.info("Request received to update an employee");
        return iEmployee.update(id, employeeDto);
    }

    @GetMapping(value = Constants.LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageableResponseDto> getListOfEmployees(@RequestParam int page, @RequestParam int size) {
        log.info("Request received to get list of employees");
        return iEmployee.getListOfEmployee(page, size);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> getAnEmployee(@RequestParam int id) {
        log.info("Request received to get an employee");
        return iEmployee.getAnEmployee(id);
    }
}
