package com.anton.hr_department.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Entity
@Table(name = "candidate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idCandidate;

    private String fio;

    private String email;

    private Date dateOfSubmission;

    private boolean applicationStatus;

    private String foreignLanguage;

    @Column(nullable = false)
    private Long idVacancy;

    @Column(nullable = false)
    private Long idEmployee;

    @Column(nullable = false)
    private Long idEducation;
}