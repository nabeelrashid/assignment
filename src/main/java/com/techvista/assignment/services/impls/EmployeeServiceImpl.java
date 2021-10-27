package com.techvista.assignment.services.impls;

import com.techvista.assignment.dtos.EmployeeDto;
import com.techvista.assignment.dtos.PageableResponseDto;
import com.techvista.assignment.dtos.ResponseDto;
import com.techvista.assignment.entities.Employee;
import com.techvista.assignment.repositories.DepartmentRepository;
import com.techvista.assignment.repositories.EmployeeRepository;
import com.techvista.assignment.services.IEmployee;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Muhammad Nabeel Rashid
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployee {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<ResponseDto> addEmployee(EmployeeDto employeeDto) {
        try {
            Employee employee = modelMapper.map(employeeDto, Employee.class);
            employee.setDepartment(departmentRepository.findByDepartmentId(employeeDto.getDepartment().getDepartmentId()));
            employeeRepository.save(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error occured", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.value(), "Employee added successfully", null));
    }

    @Override
    public ResponseEntity<ResponseDto> update(int id, EmployeeDto employeeDto) {
        try {
            if (employeeRepository.existsById(id)) {
                Employee employee = modelMapper.map(employeeDto, Employee.class);
                employee.setDepartment(departmentRepository.findByDepartmentId(employeeDto.getDepartment().getDepartmentId()));
                employee.setEmployeeId(id);
                employeeRepository.saveAndFlush(employee);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDto(HttpStatus.NO_CONTENT.value(), "Employee Not Exist", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error occured", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.value(), "Employee updated successfully", null));
    }

    @Override
    public ResponseEntity<PageableResponseDto> getListOfEmployee(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        PageableResponseDto pageableResponse = new PageableResponseDto();
        Page<Employee> employees = employeeRepository.findAll(pageRequest);
        if (employees != null && !employees.getContent().isEmpty()) {
            List<EmployeeDto> employeeDtos = modelMapper.map(employees.getContent(), List.class);
            pageableResponse.setEmployeeDtos(employeeDtos);
            pageableResponse.setPage(page);
            pageableResponse.setSize(size);
            pageableResponse.setTotalElements(employees.getNumberOfElements());
            pageableResponse.setTotalPages(employees.getTotalPages());
        } else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(pageableResponse);
    }

    @Override
    public ResponseEntity<EmployeeDto> getAnEmployee(int id) {
        Employee employee = employeeRepository.findByEmployeeId(id);
        if (employee != null)
            return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(employee, EmployeeDto.class));
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
