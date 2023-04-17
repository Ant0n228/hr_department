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
    private long idEmployee;

    @Column(name = "fio")
    private String fio;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "date_of_employment")
    private Date dateOfEmployment;

    @Column(name = "contact_details")
    private String contactDetails;

    @Column(name = "date_of_dismissal")
    private Date dateOfDismissal;

    @Column(name = "id_education")
    private long idEducation;

    @Column(name = "id_department")
    private long idDepartment;
}
