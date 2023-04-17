package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    private String fio;

    private String position;

    private double salary;

    private Date dateOfEmployment;

    private String email;

    private Date dateOfDismissal;

    @Column(nullable = false)
    private Long idEducation;

    @Column(nullable = false)
    private Long idDepartment;
}
