package com.techvista.assignment.services.impls;

import com.techvista.assignment.repositories.EmployeeRepository;
import com.techvista.assignment.services.IEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

/**
 * @author Muhammad Nabeel Rashid
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployee {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }
}
