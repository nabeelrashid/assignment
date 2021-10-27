package com.techvista.assignment.repositories;

import com.techvista.assignment.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Muhammad Nabeel Rashid
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDepartmentId(int id);
}
