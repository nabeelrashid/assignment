package com.techvista.assignment.controllers;

import com.techvista.assignment.dtos.DepartmentDto;
import com.techvista.assignment.services.IDepartment;
import com.techvista.assignment.services.IEmployee;
import com.techvista.assignment.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Muhammad Nabeel Rashid
 */
@Slf4j
@Controller
@RequestMapping(Constants.DEPARTMENT_BASE_URI)
public class DepartmentController {

    private IDepartment iDepartment;

    public DepartmentController(IDepartment iDepartment) {
        this.iDepartment = iDepartment;
    }

    @GetMapping(value = Constants.LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentDto>> getListOfDepartments() {
        log.info("Request received to get list of departments");
        return iDepartment.getListOfDepartments();
    }
}
