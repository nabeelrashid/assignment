package com.techvista.assignment.services.impls;

import com.techvista.assignment.dtos.DepartmentDto;
import com.techvista.assignment.entities.Department;
import com.techvista.assignment.repositories.DepartmentRepository;
import com.techvista.assignment.services.IDepartment;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Muhammad Nabeel Rashid
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements IDepartment {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public ResponseEntity<List<DepartmentDto>> getListOfDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = null;
        if (departments != null && !departments.isEmpty()) {
            departmentDtos = modelMapper.map(departments, List.class);
        } else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(departmentDtos);
    }
}
