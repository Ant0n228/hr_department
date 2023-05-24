package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Entity
@Table(name = "education", schema = "hr_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EducationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducation;

    private String educationalInstitution;
    private String faculty;
    private String specialization;
    private LocalDate dateOfAdmission;
    private LocalDate dateOfGraduation;

    @OneToOne(mappedBy = "education", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_education")
    private EmployeeModel employee;

    @OneToOne(mappedBy = "education", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_education")
    private CandidateModel candidate;
}
