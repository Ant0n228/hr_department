package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table(name = "employee", schema = "hr_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(nullable = false)
    private String fio;
    @Column(nullable = false)
    private String email;
    private String foreignLanguage;
    @Column(nullable = false)
    private String position;
    private double salary;
    private Date dateOfEmployment;
    private Date dateOfDismissal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_education")
    private EducationModel education;
    @ManyToOne()
    @JoinColumn(name = "id_department", nullable = false)
    private DepartmentModel department;
    @ManyToOne()
    @JoinColumn(name = "id_vacancy", nullable = false)
    private VacancyModel vacancy;

}
