package com.techvista.assignment.services;

import com.techvista.assignment.dtos.DepartmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Muhammad Nabeel Rashid
 */
public interface IDepartment {
    ResponseEntity<List<DepartmentDto>> getListOfDepartments();
}
