package com.anton.hr_department.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table(name = "education")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EducationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEducation;

    @Column(name = "educational_institution")
    private String educationalInstitution;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "date_of_admission")
    private Date dateOfAdmission;

    @Column(name = "date_of_graduation")
    private Date dateOfGraduation;
}
