package com.techvista.assignment.repositories;

import com.techvista.assignment.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Muhammad Nabeel Rashid
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
