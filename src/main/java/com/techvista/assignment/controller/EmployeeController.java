package com.techvista.assignment.controller;

import com.techvista.assignment.dto.EmployeeDto;
import com.techvista.assignment.services.IEmployee;
import com.techvista.assignment.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<EmployeeDto> indicatorDetail(@RequestBody EmployeeDto employeeDto) {
        log.debug("Request received to add an employee");
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
