package com.techvista.assignment.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @Basic
    @Column(name = "manager_id")
    private Integer managerId;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
